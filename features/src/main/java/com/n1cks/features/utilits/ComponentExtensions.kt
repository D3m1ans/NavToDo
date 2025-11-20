package com.n1cks.features.utilits

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

val ComponentContext.componentScope: CoroutineScope
    get() = CoroutineScope(SupervisorJob() + Dispatchers.Main)