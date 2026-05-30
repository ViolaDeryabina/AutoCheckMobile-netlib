package com.example.netlib.data.repositoryImpl

import com.example.netlib.data.service.AuthenticationService
import com.example.netlib.domain.repository.AuthenticationRepository
import javax.inject.Inject

// Назначение: Реализация репозитория для входа и регистрации
// Автор: Дерябина В.Н.
// Дата создания 20-05-2026
class AuthenticationRepositoryImpl @Inject constructor(private val api: AuthenticationService) :
    AuthenticationRepository {
    override suspend fun register() {
        TODO("Not yet implemented")
    }

    override suspend fun authorization() {
        TODO("Not yet implemented")
    }

}