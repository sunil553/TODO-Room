package com.sps.domain.usecase

import com.sps.domain.entity.TodoUiItemModel
import com.sps.domain.repository.TodoRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTodoUseCaseImpl @Inject constructor(private val todoRepository: TodoRepository) : GetAllTodoUseCase {
    override suspend fun invoke() : Flow<List<TodoUiItemModel>> {
       return coroutineScope { todoRepository.getAllTodos() }
    }
}