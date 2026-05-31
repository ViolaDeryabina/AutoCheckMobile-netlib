package com.example.netlib.data.repositoryImpl

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.sub.AiReviewResponse
import com.example.netlib.data.dto.sub.SubmissionResponse
import com.example.netlib.data.dto.sub.SubmissionResultsResponse
import com.example.netlib.data.dto.sub.SubmissionStatusResponse
import com.example.netlib.data.dto.sub.SubmissionsData
import com.example.netlib.data.dto.sub.VerdictUpdateRequest
import com.example.netlib.data.result.ApiCallAdapter
import com.example.netlib.data.result.NetworkResult
import com.example.netlib.data.service.SubmissionsService
import com.example.netlib.domain.repository.SubmissionsRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import java.io.File
import javax.inject.Inject

// Назначение: Реализация репозитория для управления проверками решений
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
class SubmissionsRepositoryImpl @Inject constructor(
    private val api: SubmissionsService
) : SubmissionsRepository {

    override suspend fun listSubmissions(token: String): NetworkResult<ApiResponse<SubmissionsData>> {
        return ApiCallAdapter.safeApiCall {
            api.listSubmissions("Bearer $token")
        }
    }

    override suspend fun createSubmissionWithGit(
        token: String,
        assignmentId: Int,
        gitUrl: String
    ): NetworkResult<ApiResponse<SubmissionResponse>> {
        return ApiCallAdapter.safeApiCall {
            val assignmentIdPart = assignmentId.toString()
                .toRequestBody("text/plain".toMediaTypeOrNull())
            val gitUrlPart = gitUrl
                .toRequestBody("text/plain".toMediaTypeOrNull())

            api.createSubmission(
                token = "Bearer $token",
                assignmentId = assignmentIdPart,
                gitUrl = gitUrlPart,
                zipFile = null
            )
        }
    }

    override suspend fun createSubmissionWithZip(
        token: String,
        assignmentId: Int,
        zipFile: File
    ): NetworkResult<ApiResponse<SubmissionResponse>> {
        return ApiCallAdapter.safeApiCall {
            val assignmentIdPart = assignmentId.toString()
                .toRequestBody("text/plain".toMediaTypeOrNull())

            val zipPart = MultipartBody.Part.createFormData(
                "zip_file",
                zipFile.name,
                zipFile.asRequestBody("application/zip".toMediaTypeOrNull())
            )

            api.createSubmission(
                token = "Bearer $token",
                assignmentId = assignmentIdPart,
                gitUrl = null,
                zipFile = zipPart
            )
        }
    }

    override suspend fun getSubmission(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.getSubmission("Bearer $token", submissionId)
        }
    }

    override suspend fun getSubmissionStatus(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionStatusResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.getSubmissionStatus("Bearer $token", submissionId)
        }
    }

    override suspend fun getSubmissionResults(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionResultsResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.getSubmissionResults("Bearer $token", submissionId)
        }
    }

    override suspend fun rerunSubmission(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.rerunSubmission("Bearer $token", submissionId)
        }
    }

    override suspend fun updateVerdict(
        token: String,
        submissionId: Int,
        verdict: String
    ): NetworkResult<ApiResponse<SubmissionResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.updateVerdict(
                token = "Bearer $token",
                submissionId = submissionId,
                verdictUpdate = VerdictUpdateRequest(verdict)
            )
        }
    }

    override suspend fun downloadReport(
        token: String,
        submissionId: Int
    ): NetworkResult<ResponseBody> {
        return ApiCallAdapter.safeApiCall {
            api.downloadReport("Bearer $token", submissionId)
        }
    }

    override suspend fun getAiReview(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<AiReviewResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.getAiReview("Bearer $token", submissionId)
        }
    }
}