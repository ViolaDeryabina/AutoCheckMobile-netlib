package com.example.netlib.data.service

import retrofit2.http.POST

// Назначение: Интерфейс для взаимодействия с API для регистрации и входа
// Автор: Дерябина В.Н.
// Дата создания: 26-05-2026
interface AuthenticationService {
    @POST("")
    suspend fun register()

    @POST("")
    suspend fun authorization()
}