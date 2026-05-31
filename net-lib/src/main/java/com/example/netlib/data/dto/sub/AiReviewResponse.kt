package com.example.netlib.data.dto.sub

import com.google.gson.annotations.SerializedName

// AI анализ
data class AiReviewResponse(
    @SerializedName("submissionId")
    val submissionId: Int,
    val review: String,
    val suggestions: List<String>? = null,
    val score: Int? = null
)