package com.berkayuludogan.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkayuludogan.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewmodel @Inject constructor(
    private val todoRepository: TodoRepository,
) : ViewModel() {
    fun save(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.save(name)
        }


    }

}