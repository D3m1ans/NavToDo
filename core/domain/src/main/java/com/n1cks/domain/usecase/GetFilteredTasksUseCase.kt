package com.n1cks.domain.usecase

import com.n1cks.domain.model.TaskFilter
import com.n1cks.domain.model.TaskModel
import com.n1cks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilteredTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(filter: TaskFilter): Flow<List<TaskModel>> {
        return repository.getFilteredTasks(filter = filter)
    }
}