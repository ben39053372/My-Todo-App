package com.ben39053372.myandroidtemplate.UI.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ben39053372.myandroidtemplate.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

//    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

}