package com.sps.domain.usecase

/**
 * pass on given name
 *
 */
interface InsertTodoUseCase {
    /**
     * usecase for insert
     *
     * @param todoName
     */
    suspend operator fun invoke(todoName : String)
}