package com.berkayuludogan.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.berkayuludogan.todoapp.data.entity.Todo

@Dao
interface TodoDAO {
    @Query("SELECT * FROM todo")
    suspend fun loadTodo(): List<Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Query("DELETE  FROM todo WHERE id = :id")
    suspend fun deleteTodo(id: Int)

    @Query("UPDATE todo set name =:name WHERE id = :id")
    suspend fun updateTodo(id: Int, name: String)
}