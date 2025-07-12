package com.example.taskdashboard.data.remote.api

import com.example.taskdashboard.data.remote.dto.TaskGroupResponseDto
import com.example.taskdashboard.data.remote.dto.TaskResponseDto
import retrofit2.http.GET

interface TaskApi {
    @GET("products")
    suspend fun getTasks(): TaskResponseDto

    @GET("users")
    suspend fun getTasksGroup(): TaskGroupResponseDto
}