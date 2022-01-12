package com.ben39053372.TodoApp.ui.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    var todoItems = MutableLiveData<List<TodoItem>>()
}