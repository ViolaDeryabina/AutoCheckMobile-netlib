package com.example.netlib.data.dto.sub

import com.google.gson.annotations.SerializedName

data class SubmissionResponse(
    val id: Int,
    @SerializedName("assignmentId")
    val assignmentId: Int,
    @SerializedName("candidateId")
    val candidateId: Int,
    @SerializedName("sourceType")
    val sourceType: String,
    val status: String,
    @SerializedName("finalScore")
    val finalScore: Int? = null,
    val verdict: String? = null,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)