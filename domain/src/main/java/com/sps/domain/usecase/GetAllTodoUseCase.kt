package com.sps.domain.usecase

import com.sps.domain.entity.TodoItemModel
import kotlinx.coroutines.flow.Flow

interface GetAllTodoUseCase {
    suspend operator fun invoke() : Flow<List<TodoItemModel>>
}