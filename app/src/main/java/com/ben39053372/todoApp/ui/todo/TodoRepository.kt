package com.ben39053372.todoApp.ui.todo

import android.content.Context
import kotlinx.coroutines.flow.Flow

class TodoRepository(val context: Context) {

    fun getAllTodo(): Flow<List<TodoItem>> {
        return TodoDatabase.getInstance(context).TodoItemDao().getAll()
    }

    fun getFinishedTodo(): Flow<List<TodoItem>> {
        return TodoDatabase.getInstance(context).TodoItemDao().getFinishedTodo()
    }

    fun getPendingTodo(): Flow<List<TodoItem>> {
        return TodoDatabase.getInstance(context).TodoItemDao().getPendingTodo()
    }

     fun addTodoItem(item: TodoItem) {
        TodoDatabase.getInstance(context).TodoItemDao().insertAll(item)
    }

    fun updateTodoItem(item: TodoItem) {
        TodoDatabase.getInstance(context).TodoItemDao().updateTodoItem(item)
    }
}