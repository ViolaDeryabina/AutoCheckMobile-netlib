package com.example.netlib.data.dto.sub

// Запрос на обновление вердикта
data class VerdictUpdateRequest(
    val verdict: String // "approved", "rejected", "pending"
)