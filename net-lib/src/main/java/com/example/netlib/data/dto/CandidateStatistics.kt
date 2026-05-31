package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName


// Статистика кандидата
data class CandidateStatistics(
    @SerializedName("totalSubmissions")
    val totalSubmissions: Int,
    @SerializedName("averageScore")
    val averageScore: Double,
    @SerializedName("bestScore")
    val bestScore: Int,
    @SerializedName("approvedCount")
    val approvedCount: Int,
    @SerializedName("rejectedCount")
    val rejectedCount: Int,
    @SerializedName("pendingCount")
    val pendingCount: Int
)


