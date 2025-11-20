package com.n1cks.navtodo.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.n1cks.navigation.NavigationSource
import com.n1cks.navigation.Router

class RootComponent(
    componentContext: ComponentContext
) : Router, ComponentContext by componentContext {

    private val navigation = StackNavigation<NavigationSource>()

    private val _stack: Value<ChildStack<NavigationSource, Any>> = childStack(
        source = navigation,
        serializer = NavigationSource.serializer(),
        initialConfiguration = NavigationSource.TaskList,
        handleBackButton = true,
        childFactory = ::createChild
    )

    val stack: Value<ChildStack<NavigationSource, Any>> = _stack

    override val state: Value<Router.ChildNavState>
        get() = stack.map { childStack ->
            Router.ChildNavState(
                activeChild = childStack.active.configuration,
                backStack = childStack.backStack.map { it.configuration }
            )
        }

    override fun navigateToTaskList() {
        navigation.bringToFront(NavigationSource.TaskList)
    }

    override fun navigateToTaskDetails(taskId: Long?) {
        navigation.bringToFront(NavigationSource.TaskDetails(taskId = taskId))
    }

    override fun navigateToBack() {
        navigation.pop()
    }

    fun createChild(
        config: NavigationSource,
        context: ComponentContext
    ): Any = when(config){
        is NavigationSource.TaskList -> TODO()
        is NavigationSource.TaskDetails -> TODO()
    }

}