package com.example.taskdashboard.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskdashboard.R
import com.example.taskdashboard.databinding.ActivityMainBinding
import com.example.taskdashboard.databinding.ActivityTaskScreenBinding
import com.example.taskdashboard.presentation.adapter.TaskAdapter
import com.example.taskdashboard.presentation.adapter.TaskGroupAdapter
import com.example.taskdashboard.presentation.viewmodel.TaskGroupViewModel
import com.example.taskdashboard.presentation.viewmodel.TaskViewModel
import com.example.taskdashboard.utils.ProgressDialogUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskScreen : AppCompatActivity() {
    private lateinit var binding: ActivityTaskScreenBinding
    private val viewModel: TaskViewModel by viewModels()
    private val viewModelGroup: TaskGroupViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hitGetApi()
        viewObserver()
        binding.taskGroupRecyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun hitGetApi() {
        viewModel.hitList()

    }

    private fun viewObserver() {
        viewModel.tasks.observe(this, Observer { taskList ->
            viewModelGroup. hitGroupList()
            binding.inProgressRecyclerView.adapter = TaskAdapter(taskList)
            // Set total in-progress count
            binding.inProgressCount.text = "${taskList.size}"

        })

        viewModelGroup.tasksgroup.observe(this, Observer { groupList ->
           // binding.tvName.text=groupList.get(0).firstName.toString()
            groupList.firstOrNull()?.let {
                binding.tvName.text = it.firstName ?: "User"
            }
            binding.taskGroupRecyclerView.adapter = TaskGroupAdapter(groupList)
            binding.inGroupCount.text = "${groupList.size}"

        })

        // Observe errors
        viewModel._error.observe(this, Observer { throwable ->
            Log.e("tag","error Message")
        })

        // Observe progress loader
        viewModel._progress.observe(this, Observer { isLoading ->
            if (isLoading) {
                ProgressDialogUtil.getInstance().showProgress(this, true)
            } else {
                ProgressDialogUtil.getInstance().hideProgress()
            }
        })
    }
}