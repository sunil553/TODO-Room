package com.sps.domain

import com.sps.domain.repository.TodoRepository
import com.sps.domain.usecase.InsertTodoUseCaseImpl
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class InsertTodoUseCaseImplTest {

    private lateinit var sut: InsertTodoUseCaseImpl

    private val todoRepository = mock<TodoRepository>()

    @Before
    fun setup() {
        sut = InsertTodoUseCaseImpl(
            todoRepository
        )
    }

    @Test
    fun `verify get all todo is invoke`() = runTest {
//        Given
        val titleTest = "test"

//        then
        sut.invoke(titleTest)
        verify(todoRepository).insertTodoItem(titleTest)

    }
}