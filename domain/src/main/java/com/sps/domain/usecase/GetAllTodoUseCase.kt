package com.sps.domain.usecase

import com.sps.domain.entity.TodoUiItemModel
import kotlinx.coroutines.flow.Flow

/**
 * gets all usecase wrapper
 *
 */
interface GetAllTodoUseCase {
    /**
     * wrapper method to get all values for use case
     *
     * @return
     */
    suspend operator fun invoke() : Flow<List<TodoUiItemModel>>
}