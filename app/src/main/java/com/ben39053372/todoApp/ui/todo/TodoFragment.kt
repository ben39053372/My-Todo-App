package com.ben39053372.todoApp.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.ben39053372.todoApp.R
import com.google.android.material.tabs.TabLayout

class TodoFragment : Fragment() {


    //region define var
    lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
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
        //endregion

        TodoViewPager2Adapter(requireActivity(), viewPager, tabLayout)
    }

}