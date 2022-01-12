package com.ben39053372.TodoApp.ui.todo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ben39053372.TodoApp.R

class PendingTodoListAdapter: RecyclerView.Adapter<PendingTodoListAdapter.ViewHolder>() {

    private var dataSet: List<TodoItem> = listOf()

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.todo_item_title)
        val description: TextView = view.findViewById(R.id.todo_item_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_pending_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position].name
        holder.description.text = dataSet[position].description
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun updateData(data: List<TodoItem>) {
        data.also { dataSet = it }
    }
}