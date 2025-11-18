package com.n1cks.navtodo.di

import android.content.Context
import androidx.room.Room
import com.n1cks.data.local.db.TaskDB
import com.n1cks.data.repository.TaskRepositoryImpl
import com.n1cks.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): TaskDB {
        return Room.databaseBuilder(
            context,
            TaskDB::class.java,
            "task_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: TaskDB): TaskRepository {
        return TaskRepositoryImpl(db.taskDao())
    }
}