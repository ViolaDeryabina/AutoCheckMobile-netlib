package com.example.netlib.domain.repository

// Назначение: Репозиторий для аутетификации и регистрации
// Автор: Дерябина В.Н.
// Дата создания: 26-05-2026
interface AuthenticationRepository {
    suspend fun register() //NetworkResult<>
    suspend fun authorization()  //NetworkResult<AuthResponse>
}