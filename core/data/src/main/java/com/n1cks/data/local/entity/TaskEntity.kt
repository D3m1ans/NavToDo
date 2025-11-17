package com.n1cks.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.n1cks.domain.model.TaskPriority

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val title: String,
    val desc: String? = null,
    val priority: TaskPriority = TaskPriority.MEDIUM,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val completed: Boolean = false
)