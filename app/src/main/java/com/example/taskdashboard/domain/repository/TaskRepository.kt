package com.example.taskdashboard.domain.repository

import com.example.taskdashboard.domain.model.Task
interface TaskRepository {
    suspend fun getTasks(): List<Task>
}
