package com.example.netlib.data.repositoryImpl

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.HealthResponse
import com.example.netlib.data.dto.ReportsStatsData
import com.example.netlib.data.result.ApiCallAdapter
import com.example.netlib.data.result.NetworkResult
import com.example.netlib.data.service.ReportsService
import com.example.netlib.domain.repository.ReportsRepository
import javax.inject.Inject

// Назначение: Реализация репозитория для работы с отчетами и статистикой
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
class ReportsRepositoryImpl @Inject constructor(
    private val api: ReportsService
) : ReportsRepository {

    override suspend fun getStats(token: String): NetworkResult<ApiResponse<ReportsStatsData>> {
        return ApiCallAdapter.safeApiCall {
            api.getStats("Bearer $token")
        }
    }

    override suspend fun healthCheck(): NetworkResult<HealthResponse> {
        return ApiCallAdapter.safeApiCall {
            api.healthCheck()
        }
    }
}