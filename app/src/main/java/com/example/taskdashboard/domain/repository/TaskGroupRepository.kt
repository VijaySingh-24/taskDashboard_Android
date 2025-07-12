package com.example.taskdashboard.domain.repository

import com.example.taskdashboard.domain.model.GroupTaskModel
interface TaskGroupRepository {
    suspend fun getTasks(): List<GroupTaskModel>
}