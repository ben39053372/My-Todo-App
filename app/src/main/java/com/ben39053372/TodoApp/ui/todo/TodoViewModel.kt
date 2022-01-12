package com.ben39053372.TodoApp.ui.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private val todoItems = MutableLiveData<List<TodoItem>>(
        listOf(
            TodoItem(
                name = "title 1",
                description = "this is 1"
            ),
            TodoItem(
                name = "title 2",
                description = "this is 2"
            ),TodoItem(
                name = "title 3",
                description = "this is 3"
            )
        )
    )

    fun getTodoItems(): LiveData<List<TodoItem>> {
        return todoItems
    }

}