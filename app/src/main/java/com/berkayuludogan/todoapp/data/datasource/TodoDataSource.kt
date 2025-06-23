package com.berkayuludogan.todoapp.data.datasource

import com.berkayuludogan.todoapp.data.entity.Todo
import com.berkayuludogan.todoapp.room.TodoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoDataSource @Inject constructor(private val todoDAO: TodoDAO) {
    suspend fun save(name: String) {
        val newTodo = Todo(0, name)
        todoDAO.insertTodo(newTodo)
    }

    suspend fun loadTodos(): List<Todo> = withContext(Dispatchers.IO) {
        todoDAO.loadTodo()
    }

    suspend fun deleteTodo(id: Int) = todoDAO.deleteTodo(id)

    suspend fun updateName(id: Int, name: String) = todoDAO.updateTodo(id, name)
}