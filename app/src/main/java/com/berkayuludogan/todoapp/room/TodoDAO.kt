package com.berkayuludogan.todoapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.berkayuludogan.todoapp.data.entity.Todo

@Dao
interface TodoDAO {
    @Query("SELECT * FROM todo")
    suspend fun loadTodo(): List<Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)
}