package com.n1cks.data.repository

import com.n1cks.data.local.dao.TaskDao
import com.n1cks.data.local.entity.TaskEntity
import com.n1cks.domain.model.TaskFilter
import com.n1cks.domain.model.TaskModel
import com.n1cks.domain.model.TaskPriority
import com.n1cks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
) : TaskRepository {
    override fun getAllTasks(): Flow<List<TaskModel>> {
        return dao.getAllTasks().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override fun getTaskById(taskId: Long): Flow<TaskModel> {
        return dao.getTaskById(taskId = taskId).map { entity ->
            entity.toModel()
        }
    }

    override fun getFilteredTasks(filter: TaskFilter): Flow<List<TaskModel>> {
        val priority = filter.priority
        val completed = filter.completed

        return when {
            priority != null && completed != null -> {
                dao.getTasksByPriorityAndComplete(priority = priority, completed = completed)
                    .map { entities ->
                        entities.map { it.toModel() }
                    }
            }

            priority != null -> {
                dao.getTasksByPriority(priority = priority).map { entities ->
                    entities.map { it.toModel() }
                }
            }

            completed != null -> {
                dao.getTasksByComplete(completed = completed).map { entities ->
                    entities.map { it.toModel() }
                }
            }

            else -> {
                getAllTasks()
            }
        }
    }

    override suspend fun createTask(task: TaskModel) {
        dao.createTask(task = task.toEntity())
    }

    override suspend fun deleteTask(task: TaskModel) {
        dao.deleteTask(task = task.toEntity())
    }

    override suspend fun updateTask(task: TaskModel) {
        dao.updateTask(task = task.toEntity())
    }

    override suspend fun completeTask(taskId: Long) {
        dao.completeTask(taskId = taskId)
    }

    override suspend fun changePriority(
        taskId: Long,
        priority: TaskPriority
    ) {
        dao.changePriority(taskId = taskId, priority = priority)
    }

    private fun TaskEntity.toModel(): TaskModel {
        return TaskModel(
            id = id,
            title = title,
            desc = desc,
            priority = priority,
            createdAt = createdAt,
            updatedAt = updatedAt,
            completed = completed
        )
    }

    private fun TaskModel.toEntity(): TaskEntity {
        return TaskEntity(
            id = id,
            title = title,
            desc = desc,
            priority = priority,
            createdAt = createdAt,
            updatedAt = updatedAt,
            completed = completed
        )
    }
}