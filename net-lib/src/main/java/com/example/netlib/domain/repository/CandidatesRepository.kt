package com.example.netlib.domain.repository

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.CandidateResponse
import com.example.netlib.data.dto.CandidatesData
import com.example.netlib.data.result.NetworkResult

// Назначение: Репозиторий для работы с кандидатами
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
interface CandidatesRepository {

    /**
     * GET /api/v1/candidates - Список кандидатов
     * @param token Bearer токен пользователя
     * @return NetworkResult с ApiResponse содержащим список кандидатов
     */
    suspend fun listCandidates(token: String): NetworkResult<ApiResponse<CandidatesData>>

    /**
     * GET /api/v1/candidates/{candidate_id} - Кандидат по ID
     * @param token Bearer токен пользователя
     * @param candidateId ID кандидата
     * @return NetworkResult с ApiResponse содержащим данные кандидата
     */
    suspend fun getCandidate(
        token: String,
        candidateId: Int
    ): NetworkResult<ApiResponse<CandidateResponse>>
}