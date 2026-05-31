package com.example.netlib.domain.repository

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.AssignmentsData
import com.example.netlib.data.dto.CreateAssignmentRequest
import com.example.netlib.data.dto.DeleteAssignmentResponse
import com.example.netlib.data.dto.GetAssignmentByIdResponse
import com.example.netlib.data.result.NetworkResult

interface AssignmentsRepository {
    suspend fun getAssignments(token: String): NetworkResult<ApiResponse<AssignmentsData>>

    suspend fun createAssignment(
        token: String,
        createAssignmentRequest: CreateAssignmentRequest
    ): NetworkResult<ApiResponse<GetAssignmentByIdResponse>>

    suspend fun getAssignmentById(
        token: String,
        id: Int
    ): NetworkResult<ApiResponse<GetAssignmentByIdResponse>>

    suspend fun updateAssignmentById(
        token: String,
        id: Int,
        createAssignmentRequest: CreateAssignmentRequest
    ): NetworkResult<ApiResponse<GetAssignmentByIdResponse>>

    suspend fun deleteAssignmentById(
        token: String,
        id: Int
    ): NetworkResult<ApiResponse<DeleteAssignmentResponse>>
}