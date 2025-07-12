package com.example.taskdashboard.data.remote.dto
import com.example.taskdashboard.domain.model.Task
data class TaskResponseDto(
    val products: List<TaskDto>
)
data class TaskDto(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail:String
) {
    fun toDomain(): Task = Task(id, title, description,thumbnail)
}

