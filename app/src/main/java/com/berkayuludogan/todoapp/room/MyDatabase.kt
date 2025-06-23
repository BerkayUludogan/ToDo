package com.berkayuludogan.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.berkayuludogan.todoapp.data.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun todoDAO(): TodoDAO
}