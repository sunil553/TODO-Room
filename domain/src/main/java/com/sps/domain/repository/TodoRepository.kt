package com.sps.domain.repository

import com.sps.domain.entity.TodoUiItemModel
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    /**
     * get all todo items
     *
     * @return list of todo item
     */
    suspend fun getAllTodos() : Flow<List<TodoUiItemModel>>

    /**
     * insert TODO Item
     *
     */
    suspend fun insertTodoItem(itemName: String)
}