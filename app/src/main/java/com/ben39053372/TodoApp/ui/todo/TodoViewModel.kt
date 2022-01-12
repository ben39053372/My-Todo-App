package com.ben39053372.TodoApp.ui.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class TodoItem(
    val name: String
)

class TodoViewModel : ViewModel() {
    var items = MutableLiveData<List<TodoItem>>()
}