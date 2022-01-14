package com.ben39053372.todoApp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ben39053372.todoApp.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TodoPendingFragment : Fragment() {

    companion object {
        fun newInstance() = TodoPendingFragment()
    }

    private val viewModel: TodoViewModel by activityViewModels()
    private lateinit var todoPendingList: RecyclerView
    private val todoPendingListAdapter = TodoPendingListAdapter {
        onTodoItemCheckBoxClick(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_pending_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todoPendingList = view.findViewById(R.id.todo_pending_list)
        todoPendingList.layoutManager = LinearLayoutManager(requireContext())
        todoPendingList.adapter = todoPendingListAdapter
        todoPendingList.addItemDecoration(
            DividerItemDecoration(
                todoPendingList.context,
                DividerItemDecoration.VERTICAL
            )
        )

        lifecycleScope.launch {
            // Bind Pending list and view model data
            viewModel.pendingTodo.collect {
                todoPendingListAdapter.updateData(it)
            }
        }
    }

    private fun onTodoItemCheckBoxClick(item: TodoItem) {
        viewModel.setIsDone(item)
    }

}