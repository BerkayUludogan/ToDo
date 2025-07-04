package com.berkayuludogan.todoapp.data.entity

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
):Serializable
