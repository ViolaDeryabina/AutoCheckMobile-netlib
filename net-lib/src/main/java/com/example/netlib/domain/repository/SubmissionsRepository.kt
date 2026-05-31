package com.example.netlib.domain.repository

import com.example.netlib.data.dto.ApiResponse
import com.example.netlib.data.dto.sub.AiReviewResponse
import com.example.netlib.data.dto.sub.SubmissionResponse
import com.example.netlib.data.dto.sub.SubmissionResultsResponse
import com.example.netlib.data.dto.sub.SubmissionStatusResponse
import com.example.netlib.data.dto.sub.SubmissionsData
import com.example.netlib.data.result.NetworkResult
import okhttp3.ResponseBody
import java.io.File

interface SubmissionsRepository {

    suspend fun listSubmissions(token: String): NetworkResult<ApiResponse<SubmissionsData>>

    suspend fun createSubmissionWithGit(
        token: String,
        assignmentId: Int,
        gitUrl: String
    ): NetworkResult<ApiResponse<SubmissionResponse>>

    suspend fun createSubmissionWithZip(
        token: String,
        assignmentId: Int,
        zipFile: File
    ): NetworkResult<ApiResponse<SubmissionResponse>>

    suspend fun getSubmission(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionResponse>>

    suspend fun getSubmissionStatus(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionStatusResponse>>

    suspend fun getSubmissionResults(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionResultsResponse>>

    suspend fun rerunSubmission(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<SubmissionResponse>>

    suspend fun updateVerdict(
        token: String,
        submissionId: Int,
        verdict: String
    ): NetworkResult<ApiResponse<SubmissionResponse>>

    suspend fun downloadReport(
        token: String,
        submissionId: Int
    ): NetworkResult<ResponseBody>

    suspend fun getAiReview(
        token: String,
        submissionId: Int
    ): NetworkResult<ApiResponse<AiReviewResponse>>
}