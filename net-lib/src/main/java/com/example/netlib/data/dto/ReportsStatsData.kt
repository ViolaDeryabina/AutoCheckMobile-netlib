package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

// Статистика проверок
data class ReportsStatsData(
    @SerializedName("totalSubmissions")
    val totalSubmissions: Int,
    @SerializedName("totalAssignments")
    val totalAssignments: Int,
    @SerializedName("totalCandidates")
    val totalCandidates: Int,
    @SerializedName("averageScore")
    val averageScore: Double,
    @SerializedName("approvedCount")
    val approvedCount: Int,
    @SerializedName("rejectedCount")
    val rejectedCount: Int,
    @SerializedName("pendingCount")
    val pendingCount: Int,
    @SerializedName("submissionsByDay")
    val submissionsByDay: List<DailyStats>? = null,
    @SerializedName("topCandidates")
    val topCandidates: List<TopCandidate>? = null
)
