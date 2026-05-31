package com.example.netlib.data.service

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.AssignmentsData
import com.example.netlib.data.dto.CreateAssignmentRequest
import com.example.netlib.data.dto.DeleteAssignmentResponse
import com.example.netlib.data.dto.GetAssignmentByIdResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AssignmentsService {
    @GET("v1/assignments")
    suspend fun getAssignments(@Header("Authorization") token: String): ApiResponse<AssignmentsData>

    @POST("v1/assignments")
    suspend fun createAssignments(
        @Header("Authorization") token: String,
        @Body createAssignmentRequest: CreateAssignmentRequest
    ): ApiResponse<GetAssignmentByIdResponse>

    @GET("v1/assignments/{assignment_id}")
    suspend fun getAssignmentsById(
        @Header("Authorization") token: String,
        @Path("assignment_id") id: Int
    ): ApiResponse<GetAssignmentByIdResponse>

    @PUT("v1/assignments/{assignment_id}")
    suspend fun updateAssignmentsById(
        @Header("Authorization") token: String,
        @Body createAssignmentRequest: CreateAssignmentRequest,
        @Path("assignment_id") id: Int
    ): ApiResponse<GetAssignmentByIdResponse>

    @DELETE("v1/assignments/{assignment_id}")
    suspend fun deleteAssignmentsById(
        @Header("Authorization") token: String,
        @Path("assignment_id") id: Int
    ): ApiResponse<DeleteAssignmentResponse>
}