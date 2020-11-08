package com.example.deliveryfood.ui.main.detail

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.R
import com.example.deliveryfood.data.network.RetrofitInstance
import com.example.deliveryfood.ui.main.detail.model.*

import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Response


class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var adapter: ArrayAdapter<String>
    lateinit var listView: ListView
    lateinit var alertDialog: AlertDialog.Builder
    lateinit var dialog: AlertDialog


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getRequestPath()

        val adapter = NewspaperAdapter(
            requireContext()
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.data =
            JsonHelper(requireContext()).getNewsPaperData() as MutableList<NewspaperModel>
        Log.e("Result", adapter.data.toString())

        btnAlertDialog.setOnClickListener {

            val eat = arrayOf("Snacks", "Lanch", "Breakfast", "Beverages", "Bunch")

            var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
            builder.setTitle("asd")
            builder.setItems(eat, DialogInterface.OnClickListener { dialogInterface, i ->
                when (i) {
                    0 -> {
                        var newspaperModel = NewspaperModel().apply {
                            isExpanded = true
                        }

                        adapter.onItemClicked(newspaperModel)
                        Toast.makeText(requireContext(), "Nurlan", Toast.LENGTH_LONG).show()
                    }
                }
            })
            builder.show()
        }
    }
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


    private fun getRequestPath() {
        val pathResponse: LiveData<Response<RestourantsMenuTest>> = liveData{
              val response = RetrofitInstance.api.restourantMenu("u-babushki-6udslmcmm6cmdiw")
             emit(response)
        }
        pathResponse.observe(requireActivity(), Observer {
            val response = it.body()?.items?.nonushta
           // var list:List<RestourantsMenuTest> = listOf()
           // list = it.body()?.items.nonushta.toList()

            Toast.makeText(requireContext(), response.toString(), Toast.LENGTH_LONG).show()
            Log.i("jalgas",response.toString())
        })

    }
}