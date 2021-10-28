package com.ben39053372.myandroidtemplate.UI.Second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ben39053372.myandroidtemplate.R

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    val viewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

}