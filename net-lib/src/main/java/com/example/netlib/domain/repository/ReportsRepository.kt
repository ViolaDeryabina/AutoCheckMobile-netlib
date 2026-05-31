package com.example.netlib.domain.repository

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.HealthResponse
import com.example.netlib.data.dto.ReportsStatsData
import com.example.netlib.data.result.NetworkResult

// Назначение: Репозиторий для работы с отчетами и статистикой
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
interface ReportsRepository {

    /**
     * GET /api/v1/reports/stats - Статистика проверок
     * @param token Bearer токен пользователя
     * @return NetworkResult с ApiResponse содержащим статистику
     */
    suspend fun getStats(token: String): NetworkResult<ApiResponse<ReportsStatsData>>

    /**
     * GET /health - Health check
     * @return NetworkResult со статусом здоровья сервера
     */
    suspend fun healthCheck(): NetworkResult<HealthResponse>
}