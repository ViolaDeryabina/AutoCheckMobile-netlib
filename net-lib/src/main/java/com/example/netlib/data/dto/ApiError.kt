package com.example.netlib.data.dto

// Назначение: Модель для получения ответа с ошибкой
// Автор: Дерябина В.Н.
// Дата создания: 25-05-2026
data class ApiError(
    val status: Int,
    val message: String?
)
