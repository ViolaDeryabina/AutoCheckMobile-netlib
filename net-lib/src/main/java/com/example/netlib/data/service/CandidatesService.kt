package com.example.netlib.data.service


import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.CandidateResponse
import com.example.netlib.data.dto.CandidatesData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CandidatesService {

    /**
     * GET /api/v1/candidates - Список кандидатов
     * @param token Bearer токен пользователя
     * @return ApiResponse со списком кандидатов
     */
    @GET("api/v1/candidates")
    suspend fun listCandidates(
        @Header("Authorization") token: String
    ): ApiResponse<CandidatesData>

    /**
     * GET /api/v1/candidates/{candidate_id} - Кандидат по ID
     * @param token Bearer токен пользователя
     * @param candidateId ID кандидата
     * @return ApiResponse с данными кандидата
     */
    @GET("api/v1/candidates/{candidate_id}")
    suspend fun getCandidate(
        @Header("Authorization") token: String,
        @Path("candidate_id") candidateId: Int
    ): ApiResponse<CandidateResponse>
}