package com.sps.todo.di

import com.sps.domain.repository.TodoRepository
import com.sps.domain.usecase.GetAllTodoUseCase
import com.sps.domain.usecase.GetAllTodoUseCaseImpl
import com.sps.domain.usecase.InsertTodoUseCase
import com.sps.domain.usecase.InsertTodoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetAllTodoUseCase(todoRepository: TodoRepository) : GetAllTodoUseCase {
        return  GetAllTodoUseCaseImpl(todoRepository)
    }

    @Singleton
    @Provides
    fun provideInsertTodoItemUseCase(todoRepository: TodoRepository) : InsertTodoUseCase {
        return  InsertTodoUseCaseImpl(todoRepository)
    }


}