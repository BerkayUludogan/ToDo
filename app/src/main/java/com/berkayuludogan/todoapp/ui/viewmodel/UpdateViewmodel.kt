package com.berkayuludogan.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkayuludogan.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewmodel @Inject constructor(
    val todoRepository: TodoRepository,
) : ViewModel() {

    fun updateName(id: Int, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.updateName(id, name)
        }

    }


}