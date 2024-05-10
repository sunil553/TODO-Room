package com.sps.data.datastore

import com.sps.data.db.TodoItem
import com.sps.domain.entity.TodoItemModel

interface TodoDataStore {
    /**
     * get all todo items stored in DB
     *
     * @return list of todo items
     */
    suspend fun getAllTodoItems() : List<TodoItemModel>

    /**
     * insert todo title
     *
     * @param todoItem
     */
    suspend fun insertTodoItem(todoItem: TodoItem)
}