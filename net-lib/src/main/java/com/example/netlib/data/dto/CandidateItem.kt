package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

// Элемент списка кандидатов
data class CandidateItem(
    val id: Int,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("submissionsCount")
    val submissionsCount: Int? = null,
    @SerializedName("averageScore")
    val averageScore: Double? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("createdAt")
    val createdAt: String
)
