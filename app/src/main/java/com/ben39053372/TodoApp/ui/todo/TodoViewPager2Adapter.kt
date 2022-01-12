package com.ben39053372.TodoApp.ui.todo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ben39053372.TodoApp.ui.home.HomeFragment
import com.ben39053372.TodoApp.ui.second.SecondFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A ViewPager2 adapter
 * - integrated TabLayout
 */
class TodoViewPager2Adapter(fa: FragmentActivity, viewPager: ViewPager2) :
    FragmentStateAdapter(fa) {

    var tagNameList: List<String> = listOf("Pending", "Finish")
    var fragmentList: List<Fragment> = listOf(HomeFragment(), SecondFragment())

    init {
        viewPager.adapter = this
    }

    // for tab layout
    constructor(
        fa: FragmentActivity,
        viewPager: ViewPager2,
        tabLayout: TabLayout
    ) : this(
        fa,
        viewPager
    ) {
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tagNameList[position]
        }.attach()
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}