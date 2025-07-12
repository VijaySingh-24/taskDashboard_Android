package com.example.taskdashboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskdashboard.R
import com.example.taskdashboard.databinding.ItemTaskBinding
import com.example.taskdashboard.domain.model.Task
class TaskAdapter(private val tasks: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.binding.tvProjectType.text = task.title
        holder.binding.tvProjectTitle.text = task.description
        Glide.with(holder.itemView.context)
            .load(task.thumbnail)
            .placeholder(R.drawable.ic_launcher_background)
            .into( holder.binding.ImageViewIcon)
        //ImageViewIcon
    }

    override fun getItemCount(): Int = tasks.size
}
