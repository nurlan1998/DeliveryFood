package com.example.deliveryfood.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.R
import kotlinx.android.synthetic.main.fragment_explore.*

class SearchFragment : Fragment(R.layout.fragment_explore) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSearch.setOnClickListener {
//            findNavController().navigate(R.id.action_exploreFragment_to_detailFragment)
        }
    }
}