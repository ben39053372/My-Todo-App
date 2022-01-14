package com.ben39053372.todoApp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ben39053372.todoApp.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TodoFinishedFragment : Fragment() {

    companion object {
        fun newInstance() = TodoFinishedFragment()
    }

    private val viewModel: TodoViewModel by activityViewModels()
    var todoFinishedList: RecyclerView? = null
    private val todoFinishedListAdapter = TodoFinishedListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_finished_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todoFinishedList = view.findViewById(R.id.todo_finished_list)
        todoFinishedList?.layoutManager = LinearLayoutManager(requireContext())
        todoFinishedList?.adapter = todoFinishedListAdapter

        lifecycle.coroutineScope.launch {
            viewModel.finishedTodo.collect {
                todoFinishedListAdapter.updateData(it)
            }
        }
    }

}