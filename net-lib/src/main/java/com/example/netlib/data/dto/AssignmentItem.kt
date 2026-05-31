package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName


data class AssignmentItem(
    val id: Int,
    val title: String,
    val description: String,
    @SerializedName("checkerWeights")
    val checkerWeights: CheckerWeights,
    @SerializedName("createdBy")
    val createdBy: Int,
    @SerializedName("createdAt")
    val createdAt: String
)