package com.example.netlib.data.dto.sub

import com.google.gson.annotations.SerializedName

// Детальные результаты чекеров
data class SubmissionResultsResponse(
    @SerializedName("submissionId")
    val submissionId: Int,
    val results: List<CheckerResult>
)