package com.example.taskdashboard.domain.usecase

import com.example.taskdashboard.domain.model.Task
import com.example.taskdashboard.domain.repository.TaskRepository
import javax.inject.Inject
class GetTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(): List<Task> = repository.getTasks()
}
