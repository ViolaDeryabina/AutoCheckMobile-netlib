package com.example.netlib.data.dto.sub

// Статус проверки
data class SubmissionStatusResponse(
    val status: String,
    val progress: Int? = null,
    val message: String? = null
)
