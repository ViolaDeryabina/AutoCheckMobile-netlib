package com.example.netlib.data.dto.sub

data class CheckerResult(
    val name: String,
    val score: Int,
    val maxScore: Int,
    val details: String? = null
)