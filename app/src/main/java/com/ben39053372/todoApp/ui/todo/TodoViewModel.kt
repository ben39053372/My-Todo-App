package com.ben39053372.todoApp.ui.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TodoRepository(application.applicationContext)

    val pendingTodo = repository.getPendingTodo()

    val finishedTodo = repository.getFinishedTodo()

    val allTodo = repository.getAllTodo()

    fun addTodo(todo: TodoItem) {
        repository.addTodoItem(todo)
    }

    fun setIsDone(todo: TodoItem) {
        todo.isDone = !todo.isDone
        repository.updateTodoItem(todo)
    }

}