package com.example.taskdashboard.domain.model

data class TaskGroupModel(
    val title: String,
    val taskCount: Int,
    val progress: Int,
    val iconResId: Int,
    val progressColor: Int
)
