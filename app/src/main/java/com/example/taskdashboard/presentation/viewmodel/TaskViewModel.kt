package com.example.taskdashboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdashboard.domain.model.Task
import com.example.taskdashboard.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase
) : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>(emptyList())
    val tasks: LiveData<List<Task>> = _tasks
    val _error = MutableLiveData<Throwable>()
    val _progress = MutableLiveData<Boolean>()
fun hitList() {
    viewModelScope.launch {
        try {
            _progress.postValue(true)
            val result = getTasksUseCase()
            _tasks.postValue(result)
            _progress.postValue(false)
        } catch (e: Exception) {
            _error.postValue(e)
            _progress.postValue(false)
        }
    }
}
}
