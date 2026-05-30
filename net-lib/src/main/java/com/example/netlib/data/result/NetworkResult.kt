package com.example.netlib.data.result

import android.os.Message

// Назначение: Класс для обёртки ответа
// Автор: Дерябина В.Н.
// Дата создания: 25-05-2026
sealed class NetworkResult<out T> {
    data class Success<out T>(val data:T): NetworkResult<T>()
    data class Error(val status: Int, val message: String?): NetworkResult<Nothing>()
    data class Exception(val  message: String?): NetworkResult<Nothing>()
}