package com.sps.domain.usecase

interface InsertTodoUseCase {
    suspend operator fun invoke(todoName : String)
}