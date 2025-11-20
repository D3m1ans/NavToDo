package com.n1cks.features.tasklist.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.MutableValue
import com.n1cks.domain.model.TaskModel
import com.n1cks.domain.usecase.CreateTaskUseCase
import com.n1cks.domain.usecase.GetAllTasksUseCase
import com.n1cks.features.utilits.componentScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class TaskListComponent(
    componentContext: ComponentContext,
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val createTaskUseCase: CreateTaskUseCase,
    private val onTaskSelected: (Long) -> Unit
) : ComponentContext by componentContext {

    private val _tasks: MutableValue<List<TaskModel>> = MutableValue(emptyList())
    val tasks: Value<List<TaskModel>> = _tasks

    init {
        loadTasks()
    }

    fun onCreateTaskClick() {
        val newTask = TaskModel(
            title = "New Task"
        )
        componentScope.launch {
            createTaskUseCase(task = newTask)
        }
    }

    fun onTaskClick(taskId: Long) {
        onTaskSelected(taskId)
    }

    private fun loadTasks(){
        componentScope.launch {
            getAllTasksUseCase().collect { tasks ->
                _tasks.value = tasks
            }
        }
    }

    fun onDestroy() {
        componentScope.cancel()
    }
}