package com.example.taskdashboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdashboard.domain.model.GroupTaskModel

import com.example.taskdashboard.domain.usecase.GetTasksGroupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TaskGroupViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksGroupUseCase

) : ViewModel() {
    private val _tasksgroup = MutableLiveData<List<GroupTaskModel>>(emptyList())
    val tasksgroup: LiveData<List<GroupTaskModel>> = _tasksgroup
    val _errorGroup = MutableLiveData<Throwable>()
    val _progressGroup = MutableLiveData<Boolean>()

    fun hitGroupList() {
        viewModelScope.launch {
            try {
                _progressGroup.postValue(true)
                val result = getTasksUseCase()
                _tasksgroup.postValue(result)
                _progressGroup.postValue(false)
            } catch (e: Exception) {
                _errorGroup.postValue(e)
                _progressGroup.postValue(false)
            }
        }
    }
}