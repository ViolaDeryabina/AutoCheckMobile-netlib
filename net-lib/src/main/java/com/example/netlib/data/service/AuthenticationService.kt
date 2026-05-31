package com.example.netlib.data.service

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.AuthData
import com.example.netlib.data.dto.AuthRequest
import com.example.netlib.data.dto.LogoutData
import com.example.netlib.data.dto.RegisterRequest
import com.example.netlib.data.dto.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

// Назначение: Интерфейс для взаимодействия с API для регистрации и входа
// Автор: Дерябина В.Н.
// Дата создания: 26-05-2026
interface AuthenticationService {
    @POST("v1/auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): ApiResponse<AuthData>

    @POST("v1/auth/login")
    suspend fun authorization(@Body authRequest: AuthRequest): ApiResponse<AuthData>

    @POST("v1/auth/logout")
    suspend fun logOut(@Header("Authorization")token : String): ApiResponse<LogoutData>

    @GET("v1/auth/profile")
    suspend fun getProfile(@Header("Authorization")token : String): ApiResponse<User>
}