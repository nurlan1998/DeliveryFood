package com.example.deliveryfood.ui.menu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.R
import com.example.deliveryfood.adapters.NewsPaperAdapter
import com.example.deliveryfood.data.network.RetrofitInstance
import com.example.deliveryfood.ui.menu.model.*
import kotlinx.android.synthetic.main.fragment_menu.*
import retrofit2.Response


class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var adapter: NewsPaperAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRequestPath()

        adapter =
            NewsPaperAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        var item = NewsPaperModel()
        item.isExpanded = true
        adapter.onItemClicked(item)
    }

    private fun getRequestPath() {
        val pathResponse: LiveData<Response<RestourantsMenuTest>> = liveData {
            val response = RetrofitInstance.api.restourantMenu("restaurant-neo-nxknkg0gabigc00")
            emit(response)
        }
        pathResponse.observe(requireActivity(), Observer {
            val response = it.body()?.items
            adapter.data = response!!.toMutableList()

            Log.i("jalgas", response.toString())
        })
    }
}