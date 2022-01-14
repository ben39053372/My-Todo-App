package com.ben39053372.todoApp.ui.todo

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo val name: String,
    @ColumnInfo val description: String?,
    @ColumnInfo var isDone: Boolean,
)

@Dao
interface TodoItemDao {
    @Query("SELECT * FROM TodoItem")
    fun getAll(): Flow<List<TodoItem>>

    @Query("SELECT * FROM TodoItem where isDone = 0")
    fun getPendingTodo(): Flow<List<TodoItem>>

    @Query("SELECT * FROM TodoItem where isDone = 1")
    fun getFinishedTodo(): Flow<List<TodoItem>>

    @Query("SELECT * FROM TodoItem WHERE uid IN (:ids)")
    fun loadAllByIds(ids: IntArray): Flow<List<TodoItem>>

    @Insert
    fun insertAll(vararg todos: TodoItem)

    @Update
    fun updateTodoItem(vararg todo: TodoItem)

    @Delete
    fun delete(todoItem: TodoItem)
}

