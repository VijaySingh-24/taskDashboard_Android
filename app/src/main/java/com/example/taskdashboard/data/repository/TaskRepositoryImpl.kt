package com.example.taskdashboard.data.repository

import com.example.taskdashboard.data.remote.api.TaskApi
import com.example.taskdashboard.domain.model.Task
import com.example.taskdashboard.domain.repository.TaskRepository
import javax.inject.Inject
class TaskRepositoryImpl @Inject constructor(
    private val api: TaskApi
) : TaskRepository {
    override suspend fun getTasks(): List<Task> {
        return api.getTasks().products.map { it.toDomain() }
    }
}
