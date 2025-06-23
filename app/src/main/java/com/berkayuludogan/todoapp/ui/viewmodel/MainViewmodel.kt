package com.berkayuludogan.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.berkayuludogan.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    val todoRepository: TodoRepository
) :ViewModel() {
}