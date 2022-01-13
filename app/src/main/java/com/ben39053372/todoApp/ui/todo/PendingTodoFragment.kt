package com.ben39053372.todoApp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ben39053372.todoApp.R

class PendingTodoFragment : Fragment() {

    companion object {
        fun newInstance() = PendingTodoFragment()
    }

    val viewModel: TodoViewModel by activityViewModels()
    lateinit var todoPendingList: RecyclerView
    private val todoPendingListAdapter = PendingTodoListAdapter()

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

        viewModel.getTodoItems().observe(viewLifecycleOwner, Observer<List<TodoItem>> {
            todoPendingListAdapter.updateData(it)
            todoPendingListAdapter.notifyDataSetChanged()
        })
    }


}