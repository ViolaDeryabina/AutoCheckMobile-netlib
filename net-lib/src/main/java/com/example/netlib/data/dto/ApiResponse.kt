package com.example.netlib.data.dto

data class ApiResponse<T>(
    val data: T,
    val error: String? = null,
    val meta: Meta
)