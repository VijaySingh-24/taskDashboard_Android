package com.example.taskdashboard.data.remote.dto


import com.example.taskdashboard.domain.model.GroupTaskModel
import com.example.taskdashboard.domain.model.Task

data class TaskGroupResponseDto(
    val users: List<TaskGropDto>
)
data class TaskGropDto(
    val id: Int,
    val firstName: String,
    val age: String,
    val image: String
) {
    fun toDomain(): GroupTaskModel = GroupTaskModel(id, firstName, age, image)
}
