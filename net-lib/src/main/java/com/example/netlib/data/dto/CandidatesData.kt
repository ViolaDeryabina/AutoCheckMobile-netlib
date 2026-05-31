package com.example.netlib.data.dto

// Ответ со списком кандидатов
data class CandidatesData(
    val items: List<CandidateItem>,
    val total: Int
)
