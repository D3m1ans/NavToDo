package com.n1cks.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.n1cks.data.local.entity.TaskEntity
import com.n1cks.domain.model.TaskPriority
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task ORDER BY createdAt")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE id =:taskId")
    fun getTaskById(taskId: Long): Flow<TaskEntity>

    @Query("SELECT * FROM task WHERE priority =:priority")
    fun getTasksByPriority(priority: TaskPriority): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE completed =:completed")
    fun getTasksByComplete(completed: Boolean): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE priority =:priority AND completed =:completed")
    fun getTasksByPriorityAndComplete(
        priority: TaskPriority,
        completed: Boolean
    ): Flow<List<TaskEntity>>

    @Insert
    suspend fun createTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("UPDATE task SET completed = 1 WHERE id =:taskId")
    suspend fun completeTask(taskId: Long)

    @Query("UPDATE task SET priority =:priority WHERE id =:taskId")
    suspend fun changePriority(taskId: Long, priority: TaskPriority)
}