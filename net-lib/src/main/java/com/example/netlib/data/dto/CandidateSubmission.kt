package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

// Работы кандидата
data class CandidateSubmission(
    val id: Int,
    @SerializedName("assignmentId")
    val assignmentId: Int,
    @SerializedName("assignmentTitle")
    val assignmentTitle: String,
    val status: String,
    @SerializedName("finalScore")
    val finalScore: Int? = null,
    val verdict: String? = null,
    @SerializedName("createdAt")
    val createdAt: String
)