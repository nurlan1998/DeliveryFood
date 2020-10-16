package com.example.deliveryfood.ui.main.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.R
import com.example.deliveryfood.ui.main.detail.model.JsonHelper
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment(R.layout.fragment_detail) {

    val eat: ArrayList<String> = arrayListOf("Snacks", "Lanch", "Breakfast", "Beverages", "Bunch")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewspaperAdapter(
            requireContext(), JsonHelper(
                requireContext()
            ).getNewsPaperData()
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        btnAlertDialog.setOnClickListener {
//
//            fun showListAlertDialoge(view: View) {
//                val builder = android.app.AlertDialog.Builder(requireContext())
//                builder.setTitle("dfs")
//
//                builder.setItems(eat, DialogInterface.OnClickListener!)
//                //{ dialog, which ->
//                    Toast.makeText(requireContext(), eat[which], Toast.LENGTH_LONG).show()
//
//                })
//                val dialog = builder.create()
//                dialog.show()
//
//            }

        }

    }

}