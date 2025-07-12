package com.example.taskdashboard.data.repository
import com.example.taskdashboard.data.remote.api.TaskApi
import com.example.taskdashboard.domain.model.GroupTaskModel
import com.example.taskdashboard.domain.repository.TaskGroupRepository
import javax.inject.Inject

class TaskGroupRepositoryImpl @Inject constructor(
    private val api: TaskApi
) : TaskGroupRepository {
    override suspend fun getTasks(): List<GroupTaskModel> {
        return api.getTasksGroup().users.map { it.toDomain() }
    }
}

