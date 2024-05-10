package com.sps.domain.usecase

import com.sps.domain.repository.TodoRepository
import javax.inject.Inject

class InsertTodoUseCaseImpl @Inject constructor(private val todoRepository: TodoRepository): InsertTodoUseCase {
    override suspend fun invoke(todoName : String) {
        todoRepository.insertTodoItem(todoName)
    }
}