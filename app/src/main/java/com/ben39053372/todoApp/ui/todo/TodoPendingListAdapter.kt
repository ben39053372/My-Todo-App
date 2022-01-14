package com.ben39053372.todoApp.ui.todo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ben39053372.todoApp.R

class TodoPendingListAdapter(private val onItemCheckBoxClick: (item: TodoItem) -> Unit): RecyclerView.Adapter<TodoPendingListAdapter.ViewHolder>() {

    private var dataSet: List<TodoItem> = listOf()

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.todo_item_title)
        val description: TextView = view.findViewById(R.id.todo_item_description)
        val checkBox: CheckBox = view.findViewById(R.id.todo_item_isDone_checkBox)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_pending_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position].name
        holder.description.text = dataSet[position].description
        holder.checkBox.isChecked = dataSet[position].isDone
        holder.checkBox.setOnClickListener {
            Thread {
                holder.checkBox.isChecked = !dataSet[position].isDone
                Thread.sleep(1000)
                onItemCheckBoxClick(dataSet[position])
            }.start()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<TodoItem>) {
        data.also { dataSet = it }
        notifyDataSetChanged()
    }
}