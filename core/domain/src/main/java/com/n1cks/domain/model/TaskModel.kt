package com.n1cks.domain.model

data class TaskModel(
    val id: Long = 0,
    val text: String,
    val desc: String? = null,
    val priority: TaskPriority = TaskPriority.MEDIUM,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val completed: Boolean = false
)