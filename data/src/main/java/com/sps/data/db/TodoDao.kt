package com.sps.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Query("SELECT * FROM TodoItem")
    fun getAllTodos(): List<TodoItem>

    // 3. Insert Operation for Adding or Updating Items
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TodoItem)

}