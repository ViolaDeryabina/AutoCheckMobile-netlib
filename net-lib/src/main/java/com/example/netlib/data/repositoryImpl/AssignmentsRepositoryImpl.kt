package com.example.netlib.data.repositoryImpl

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.AssignmentsData
import com.example.netlib.data.dto.CreateAssignmentRequest
import com.example.netlib.data.dto.DeleteAssignmentResponse
import com.example.netlib.data.dto.GetAssignmentByIdResponse
import com.example.netlib.data.result.ApiCallAdapter
import com.example.netlib.data.result.NetworkResult
import com.example.netlib.data.service.AssignmentsService
import com.example.netlib.domain.repository.AssignmentsRepository
import javax.inject.Inject

// Назначение: Реализация репозитория для управления заданиями
// Автор: Дерябина В.Н.
// Дата создания 31-05-2026
class AssignmentsRepositoryImpl @Inject constructor(private val api: AssignmentsService) :
    AssignmentsRepository {

    override suspend fun getAssignments(token: String): NetworkResult<ApiResponse<AssignmentsData>> {
        return ApiCallAdapter.safeApiCall { api.getAssignments("Bearer $token") }
    }

    override suspend fun createAssignment(
        token: String,
        createAssignmentRequest: CreateAssignmentRequest
    ): NetworkResult<ApiResponse<GetAssignmentByIdResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.createAssignments(
                token = "Bearer $token",
                createAssignmentRequest = createAssignmentRequest
            )
        }
    }

    override suspend fun getAssignmentById(
        token: String,
        id: Int
    ): NetworkResult<ApiResponse<GetAssignmentByIdResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.getAssignmentsById(
                token = "Bearer $token",
                id = id
            )
        }
    }

    override suspend fun updateAssignmentById(
        token: String,
        id: Int,
        createAssignmentRequest: CreateAssignmentRequest
    ): NetworkResult<ApiResponse<GetAssignmentByIdResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.updateAssignmentsById(
                token = "Bearer $token",
                id = id,
                createAssignmentRequest = createAssignmentRequest
            )
        }
    }

    override suspend fun deleteAssignmentById(
        token: String,
        id: Int
    ): NetworkResult<ApiResponse<DeleteAssignmentResponse>> {
        return ApiCallAdapter.safeApiCall {
            api.deleteAssignmentsById(
                token = "Bearer $token",
                id = id
            )
        }
    }
}