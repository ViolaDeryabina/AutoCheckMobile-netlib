package com.example.netlib.data.service

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.HealthResponse
import com.example.netlib.data.dto.ReportsStatsData
import retrofit2.http.GET
import retrofit2.http.Header

interface ReportsService {

    /**
     * GET /api/v1/reports/stats - Статистика проверок
     * @param token Bearer токен пользователя
     * @return ApiResponse со статистикой проверок
     */
    @GET("api/v1/reports/stats")
    suspend fun getStats(
        @Header("Authorization") token: String
    ): ApiResponse<ReportsStatsData>

    /**
     * GET /health - Health check
     * @return статус здоровья сервера
     */
    @GET("health")
    suspend fun healthCheck(): HealthResponse
}