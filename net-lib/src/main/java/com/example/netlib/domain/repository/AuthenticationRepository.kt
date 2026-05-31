package com.example.netlib.domain.repository

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.AuthData
import com.example.netlib.data.dto.AuthRequest
import com.example.netlib.data.dto.LogoutData
import com.example.netlib.data.dto.RegisterRequest
import com.example.netlib.data.dto.User
import com.example.netlib.data.result.NetworkResult

// Назначение: Репозиторий для аутетификации и регистрации
// Автор: Дерябина В.Н.
// Дата создания: 26-05-2026
interface AuthenticationRepository {
    suspend fun register(registerRequest: RegisterRequest): NetworkResult<ApiResponse<AuthData>>
    suspend fun authorization(authRequest: AuthRequest): NetworkResult<ApiResponse<AuthData>>

    suspend fun logOut(token: String): NetworkResult<ApiResponse<LogoutData>>

    suspend fun getProfile(token: String): NetworkResult<ApiResponse<User>>
}