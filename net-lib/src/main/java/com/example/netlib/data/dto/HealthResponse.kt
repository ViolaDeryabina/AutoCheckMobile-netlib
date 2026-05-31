package com.example.netlib.data.dto

// Health check ответ
data class HealthResponse(
    val status: String, // "ok", "degraded", "down"
    val timestamp: String,
    val version: String? = null,
    val services: Map<String, String>? = null
)
