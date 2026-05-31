package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

// Детальная информация о кандидате
data class CandidateResponse(
    val id: Int,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("submissions")
    val submissions: List<CandidateSubmission>? = null,
    @SerializedName("statistics")
    val statistics: CandidateStatistics? = null,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)