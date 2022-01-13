package com.ben39053372.todoApp.ui.viewPager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ben39053372.todoApp.R
import com.google.android.material.tabs.TabLayout

class ViewPager2Fragment : Fragment() {

    //region define var
    lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    //endregion

    //region lifecycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region define components
        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.pager)
        //endregion

        ViewPager2Adapter(requireActivity(), viewPager, tabLayout)
    }
    //endregion
}