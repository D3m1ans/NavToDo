package com.n1cks.di

import com.n1cks.domain.repository.TaskRepository
import com.n1cks.domain.usecase.ChangePriorityUseCase
import com.n1cks.domain.usecase.CompleteTaskUseCase
import com.n1cks.domain.usecase.CreateTaskUseCase
import com.n1cks.domain.usecase.DeleteTaskUseCase
import com.n1cks.domain.usecase.GetAllTasksUseCase
import com.n1cks.domain.usecase.GetFilteredTasksUseCase
import com.n1cks.domain.usecase.GetTaskByIdUseCase
import com.n1cks.domain.usecase.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetAllTasksUseCase(repository: TaskRepository): GetAllTasksUseCase {
        return GetAllTasksUseCase(repository)
    }

    @Provides
    fun provideGetTaskByIdUseCase(repository: TaskRepository): GetTaskByIdUseCase {
        return GetTaskByIdUseCase(repository)
    }

    @Provides
    fun provideGetFilteredTasks(repository: TaskRepository): GetFilteredTasksUseCase {
        return GetFilteredTasksUseCase(repository)
    }

    @Provides
    fun provideCreateTaskUseCase(repository: TaskRepository): CreateTaskUseCase {
        return CreateTaskUseCase(repository)
    }

    @Provides
    fun provideDeleteTaskUseCase(repository: TaskRepository): DeleteTaskUseCase {
        return DeleteTaskUseCase(repository)
    }

    @Provides
    fun provideUpdateTaskUseCase(repository: TaskRepository): UpdateTaskUseCase {
        return UpdateTaskUseCase(repository)
    }

    @Provides
    fun provideCompleteTaskUseCase(repository: TaskRepository): CompleteTaskUseCase {
        return CompleteTaskUseCase(repository)
    }

    @Provides
    fun provideChangePriorityUseCase(repository: TaskRepository): ChangePriorityUseCase {
        return ChangePriorityUseCase(repository)
    }
}