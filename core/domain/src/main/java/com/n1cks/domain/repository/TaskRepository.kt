package com.n1cks.domain.repository

import com.n1cks.domain.model.TaskFilter
import com.n1cks.domain.model.TaskModel
import com.n1cks.domain.model.TaskPriority
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<TaskModel>>
    fun getTaskById(taskId: Long): Flow<TaskModel>
    fun getFilteredTasks(filter: TaskFilter): Flow<List<TaskModel>>
    suspend fun createTask(task: TaskModel)
    suspend fun deleteTask(task: TaskModel)
    suspend fun updateTask(task: TaskModel)
    suspend fun completeTask(taskId: Long)
    suspend fun changePriority(taskId: Long, priority: TaskPriority)
}