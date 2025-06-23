package com.berkayuludogan.todoapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkayuludogan.todoapp.data.entity.Todo
import com.berkayuludogan.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    val todoRepository: TodoRepository,
) : ViewModel() {
    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    init {
        loadTodos()
    }


    fun loadTodos() {
        viewModelScope.launch(Dispatchers.Main) {
            _todoList.value = todoRepository.loadTodos()
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            todoRepository.deleteTodo(id)
            loadTodos()
        }
    }
}