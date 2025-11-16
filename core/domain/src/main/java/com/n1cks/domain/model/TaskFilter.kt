package com.n1cks.domain.model

data class TaskFilter(
    val priority: TaskPriority? = null,
    val completed: Boolean? = null,
) {
    companion object {
        val DEFAULT = TaskFilter()
    }

    fun hasFilters(): Boolean{
        return priority != null || completed != null
    }
}