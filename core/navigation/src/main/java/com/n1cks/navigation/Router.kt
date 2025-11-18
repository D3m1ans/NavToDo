package com.n1cks.navigation

import com.arkivanov.decompose.value.Value

interface Router {

    val state: Value<ChildNavState>

    fun navigateToTaskList()
    fun navigateToTaskDetails(taskId: Long? = null)
    fun navigateToBack()

    data class ChildNavState(
        val activeChild: NavigationSource,
        val backStack: List<NavigationSource>
    )
}