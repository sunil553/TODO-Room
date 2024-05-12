package com.sps.data.datastore

import com.sps.data.db.TodoItem
import com.sps.domain.entity.TodoUiItemModel

interface TodoDataStore {
    /**
     * get all todo items stored in DB
     *
     * @return list of todo items
     */
    suspend fun getAllTodoItems() : List<TodoUiItemModel>

    /**
     * insert todo title
     *
     * @param todoItem
     */
    suspend fun insertTodoItem(todoItem: TodoItem)
}