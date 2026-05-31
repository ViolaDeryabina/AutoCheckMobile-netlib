package com.example.netlib.data.dto

data class AuthData(
    val accessToken: String,
    val tokenType: String = "Bearer",
    val expiresInSec: Int,
    val user: User
)