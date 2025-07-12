package com.example.taskdashboard.domain.usecase
import com.example.taskdashboard.domain.model.GroupTaskModel
import com.example.taskdashboard.domain.repository.TaskGroupRepository
import javax.inject.Inject
class GetTasksGroupUseCase @Inject constructor(
    private val repository1: TaskGroupRepository
) {
    suspend operator fun invoke(): List<GroupTaskModel> = repository1.getTasks()
}