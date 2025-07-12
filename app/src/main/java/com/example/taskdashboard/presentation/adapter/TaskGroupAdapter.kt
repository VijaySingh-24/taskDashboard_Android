package com.example.taskdashboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskdashboard.R
import com.example.taskdashboard.databinding.ItemTaskGroupBinding
import com.example.taskdashboard.domain.model.GroupTaskModel


class TaskGroupAdapter(private val list: List<GroupTaskModel>) :
    RecyclerView.Adapter<TaskGroupAdapter.TaskGroupViewHolder>() {

    inner class TaskGroupViewHolder(val binding: ItemTaskGroupBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskGroupViewHolder {
        val binding = ItemTaskGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskGroupViewHolder(binding)
    }
    override fun onBindViewHolder(holder: TaskGroupViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            titleTextView.text = item.firstName
            taskCountTextView.text = "${item.id} Tasks"
            Glide.with(holder.itemView.context)
                .load(item.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(iconImageView)
           // iconImageView.setImageResource(item.iconResId)
           // progressIndicator.setProgressCompat(item.users.get(0).weight.toInt(), true)
            //progressIndicator.setIndicatorColor(item.progressColor)
        }
    }

    override fun getItemCount(): Int = list.size
}
