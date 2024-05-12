package com.sps.data.repository

import com.sps.data.datastore.TodoDataStore
import com.sps.data.db.TodoItem
import com.sps.domain.entity.TodoUiItemModel
import com.sps.domain.repository.TodoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class TodoRepositoryImplTest {

    private lateinit var sut: TodoRepository

    private val todoDataStore = mock<TodoDataStore>()
    private val todoUiItemModel = mock<TodoUiItemModel>()

    @Before
    fun setup() {
        sut = TodoRepositoryImpl(
            todoDataStore
        )
    }

    @Test
    fun `verify test getAllTodos`(): Unit = runTest {
        // When given
        whenever(todoDataStore.getAllTodoItems()).thenReturn(listOf(todoUiItemModel))
        val result = sut.getAllTodos()

        // Then
        val resultList = mutableListOf<TodoUiItemModel>()
        result.collect {
            resultList.addAll(it)
        }
        assertEquals(listOf(todoUiItemModel), resultList)
    }

    @Test
    fun `verify test insertTodoItem`() = runTest {
        // Given
        val itemName = "New Todo"
        val expectedTodoItem = TodoItem(title = itemName)

        // When
        sut.insertTodoItem(itemName)

        // Then
        verify(todoDataStore, times(1)).insertTodoItem(expectedTodoItem)
        verifyNoMoreInteractions(todoDataStore)
    }
}