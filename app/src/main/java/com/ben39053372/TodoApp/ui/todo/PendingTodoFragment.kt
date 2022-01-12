package com.ben39053372.TodoApp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ben39053372.TodoApp.R

class PendingTodoFragment : Fragment() {

    companion object {
        fun newInstance() = PendingTodoFragment()
    }

    val viewModel: TodoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_pending_fragment, container, false)
    }

}