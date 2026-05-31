package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

// Топ кандидатов
data class TopCandidate(
    val id: Int,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("averageScore")
    val averageScore: Double,
    @SerializedName("submissionsCount")
    val submissionsCount: Int
)
