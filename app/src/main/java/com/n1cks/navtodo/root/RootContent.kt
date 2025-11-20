package com.n1cks.navtodo.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children

@Composable
fun RootContent(component: RootComponent) {
    Children(
        stack = component.stack
    ) { child ->
        when (val instance = child.instance) {

        }
    }
}