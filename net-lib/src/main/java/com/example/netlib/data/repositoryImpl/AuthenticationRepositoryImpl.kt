package com.example.netlib.data.repositoryImpl

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.AuthData
import com.example.netlib.data.dto.AuthRequest
import com.example.netlib.data.dto.LogoutData
import com.example.netlib.data.dto.RegisterRequest
import com.example.netlib.data.dto.User
import com.example.netlib.data.result.ApiCallAdapter
import com.example.netlib.data.result.NetworkResult
import com.example.netlib.data.service.AuthenticationService
import com.example.netlib.domain.repository.AuthenticationRepository
import javax.inject.Inject

// Назначение: Реализация репозитория для входа и регистрации
// Автор: Дерябина В.Н.
// Дата создания 20-05-2026
class AuthenticationRepositoryImpl @Inject constructor(private val api: AuthenticationService) :
    AuthenticationRepository {
    override suspend fun register(registerRequest: RegisterRequest): NetworkResult<ApiResponse<AuthData>> {
        return ApiCallAdapter.safeApiCall { api.register(registerRequest) }
    }

    override suspend fun authorization(authRequest: AuthRequest): NetworkResult<ApiResponse<AuthData>> {
        return ApiCallAdapter.safeApiCall { api.authorization(authRequest) }
    }

    override suspend fun logOut(token: String): NetworkResult<ApiResponse<LogoutData>> {
        return ApiCallAdapter.safeApiCall { api.logOut(token) }
    }

    override suspend fun getProfile(token: String): NetworkResult<ApiResponse<User>> {
        return ApiCallAdapter.safeApiCall { api.getProfile(token) }
    }
}