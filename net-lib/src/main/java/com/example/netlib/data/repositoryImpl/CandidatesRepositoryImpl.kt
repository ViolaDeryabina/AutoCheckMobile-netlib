package com.example.netlib.data.repositoryImpl

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.CandidateResponse
import com.example.netlib.data.dto.CandidatesData
import com.example.netlib.data.result.ApiCallAdapter
import com.example.netlib.data.result.NetworkResult
import com.example.netlib.data.service.CandidatesService
import com.example.netlib.domain.repository.CandidatesRepository
import javax.inject.Inject

// Назначение: Реализация репозитория для работы с кандидатами
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
class CandidatesRepositoryImpl @Inject constructor(
    private val api: CandidatesService
) : CandidatesRepository {

    override suspend fun listCandidates(token: String): NetworkResult<ApiResponse<CandidatesData>> {
        return ApiCallAdapter.safeApiCall {
            api.listCandidates("Bearer $token")
        }
    }

    override suspend fun getCandidate(
        token: String,
        candidateId: Int
    ): NetworkResult<ApiResponse<CandidateResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.getCandidate("Bearer $token", candidateId)
        }
    }
}