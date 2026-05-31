package com.example.netlib.data.service

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.sub.AiReviewResponse
import com.example.netlib.data.dto.sub.SubmissionResponse
import com.example.netlib.data.dto.sub.SubmissionResultsResponse
import com.example.netlib.data.dto.sub.SubmissionStatusResponse
import com.example.netlib.data.dto.sub.SubmissionsData
import com.example.netlib.data.dto.sub.VerdictUpdateRequest
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Streaming

interface SubmissionsService {

    // GET /api/v1/submissions - Список проверок
    @GET("api/v1/submissions")
    suspend fun listSubmissions(
        @Header("Authorization") token: String
    ): ApiResponse<SubmissionsData>

    // POST /api/v1/submissions - Загрузить решение (ZIP или Git URL)
    @Multipart
    @POST("api/v1/submissions")
    suspend fun createSubmission(
        @Header("Authorization") token: String,
        @Part("assignment_id") assignmentId: RequestBody,
        @Part("git_url") gitUrl: RequestBody? = null,
        @Part("zip_file") zipFile: MultipartBody.Part? = null
    ): ApiResponse<SubmissionResponse>

    // GET /api/v1/submissions/{submission_id} - Проверка по ID
    @GET("api/v1/submissions/{submission_id}")
    suspend fun getSubmission(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ApiResponse<SubmissionResponse>

    // GET /api/v1/submissions/{submission_id}/status - Текущий статус проверки
    @GET("api/v1/submissions/{submission_id}/status")
    suspend fun getSubmissionStatus(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ApiResponse<SubmissionStatusResponse>

    // GET /api/v1/submissions/{submission_id}/results - Детальные результаты чекеров
    @GET("api/v1/submissions/{submission_id}/results")
    suspend fun getSubmissionResults(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ApiResponse<SubmissionResultsResponse>

    // POST /api/v1/submissions/{submission_id}/rerun - Повторный запуск проверки
    @POST("api/v1/submissions/{submission_id}/rerun")
    suspend fun rerunSubmission(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ApiResponse<SubmissionResponse>

    // PUT /api/v1/submissions/{submission_id}/verdict - Вынести вердикт
    @PUT("api/v1/submissions/{submission_id}/verdict")
    suspend fun updateVerdict(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int,
        @Body verdictUpdate: VerdictUpdateRequest
    ): ApiResponse<SubmissionResponse>

    // GET /api/v1/submissions/{submission_id}/report - Скачать отчёт по проверке
    @GET("api/v1/submissions/{submission_id}/report")
    @Streaming
    suspend fun downloadReport(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ResponseBody

    // GET /api/v1/submissions/{submission_id}/ai-review - AI-анализ решения
    @GET("api/v1/submissions/{submission_id}/ai-review")
    suspend fun getAiReview(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ApiResponse<AiReviewResponse>

    // GET /api/v1/submissions/{submission_id}/events - SSE-поток статусов проверки
    @GET("api/v1/submissions/{submission_id}/events")
    @Headers("Accept: text/event-stream")
    suspend fun getSubmissionEvents(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): ResponseBody

    // Альтернативный вариант для SSE с Flow
    @GET("api/v1/submissions/{submission_id}/events")
    @Headers("Accept: text/event-stream")
    fun getSubmissionEventsFlow(
        @Header("Authorization") token: String,
        @Path("submission_id") submissionId: Int
    ): Flow<ResponseBody>
}