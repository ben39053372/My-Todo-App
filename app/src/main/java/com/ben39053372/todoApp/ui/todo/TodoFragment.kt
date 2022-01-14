package com.ben39053372.todoApp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.ben39053372.todoApp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch
import timber.log.Timber

class TodoFragment : Fragment() {


    //region define var
    lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    var floatingActionButton: FloatingActionButton? = null
    val viewModel: TodoViewModel by viewModels()
    //endregion


    companion object {
        fun newInstance() = TodoFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //region define components
        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.pager)
        floatingActionButton = view.findViewById(R.id.floatingActionButton)
        //endregion

        TodoViewPager2Adapter(requireActivity(), viewPager, tabLayout)

        Thread {
            Timber.d("floatingActionButton click !!")
            viewModel.addTodo(
                TodoItem(
                    name = "first",
                    description = "this is my first",
                    isDone = false
                )
            )
        }.start()
    }

}