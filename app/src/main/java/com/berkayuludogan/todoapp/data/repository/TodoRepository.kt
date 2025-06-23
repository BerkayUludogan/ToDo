package com.berkayuludogan.todoapp.data.repository

import com.berkayuludogan.todoapp.data.datasource.TodoDataSource
import com.berkayuludogan.todoapp.data.entity.Todo
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDataSource: TodoDataSource) {
    suspend fun save(name: String) = todoDataSource.save(name)
    suspend fun loadTodos(): List<Todo> = todoDataSource.loadTodos()
    suspend fun deleteTodo(id: Int) = todoDataSource.deleteTodo(id)
    suspend fun updateName(id: Int, name: String) = todoDataSource.updateName(id, name)
}