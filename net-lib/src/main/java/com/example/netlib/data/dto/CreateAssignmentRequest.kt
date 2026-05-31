package com.example.netlib.data.dto

import com.google.gson.annotations.SerializedName

data class CreateAssignmentRequest(
    val title: String,
    val description: String,
    @SerializedName("checker_weights")
    val checkerWeights: Map<String, Int>  // используем Map для динамических ключей
)