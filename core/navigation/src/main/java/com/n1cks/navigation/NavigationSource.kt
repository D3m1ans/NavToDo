package com.n1cks.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationSource {
    @Serializable
    data object TaskList : NavigationSource()

    @Serializable
    data class TaskDetails(val taskId: Long? = null) : NavigationSource()
}