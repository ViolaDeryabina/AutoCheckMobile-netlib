package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

// Статистика по дням
data class DailyStats(
    val date: String,
    val count: Int,
    @SerializedName("averageScore")
    val averageScore: Double
)