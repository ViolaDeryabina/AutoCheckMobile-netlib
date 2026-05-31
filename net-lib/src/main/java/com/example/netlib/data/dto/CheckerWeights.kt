package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName


data class CheckerWeights(
    @SerializedName("static_analysis")
    val staticAnalysis: Int,
    val architecture: Int,
    val build: Int,
    val tests: Int,
    val documentation: Int,
    @SerializedName("git_practices")
    val gitPractices: Int
)