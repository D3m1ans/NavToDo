package com.n1cks.domain.usecase

import com.n1cks.domain.model.TaskPriority
import com.n1cks.domain.repository.TaskRepository
import javax.inject.Inject

class ChangePriorityUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskId: Long, priority: TaskPriority) {
        repository.changePriority(taskId = taskId, priority = priority)
    }
}