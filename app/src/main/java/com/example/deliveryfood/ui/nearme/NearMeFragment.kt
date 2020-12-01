package com.example.deliveryfood.ui.nearme

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.R
import com.example.deliveryfood.adapters.NearMeAdapter
import com.example.deliveryfood.adapters.NearMeHorizontalAdapter
import com.example.deliveryfood.data.Repository
import kotlinx.android.synthetic.main.fragment_near_me.*

class NearMeFragment : Fragment(R.layout.fragment_near_me) {

    private lateinit var mNearMeFragmentViewModel: NearMeViewModel
    private lateinit var mNearMeViewModelFactory: NearMeViewModelFactory
    private lateinit var adapter: NearMeAdapter
    private lateinit var adapterHorizontal: NearMeHorizontalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        init()

//        mNearMeFragmentViewModel.startViewModel()
//
//        mNearMeFragmentViewModel.restaurantLiveData.observe(requireActivity(), Observer {
//            adapter.models = it
//            adapterHorizontal.horizontalModel = it
//        })
//
        mNearMeFragmentViewModel.restaurantLiveData.observe(requireActivity(), Observer {
            val restaurantsList = it.body()?.toList()
            Log.i("Res", restaurantsList.toString())
            if (restaurantsList != null) {
                adapter.models = restaurantsList
                adapterHorizontal.horizontalModel = restaurantsList
            }
        })
    }

    private fun init() {
        val repository = Repository()
        mNearMeViewModelFactory = NearMeViewModelFactory(Application(), repository)
        mNearMeFragmentViewModel = ViewModelProvider(this, mNearMeViewModelFactory)
            .get(NearMeViewModel::class.java)
        mNearMeFragmentViewModel.getRestaurants("41.311081", "69.240562")
    }

    private fun setRecyclerView() {
        adapter = NearMeAdapter()
        adapterHorizontal =
            NearMeHorizontalAdapter()
        rvNearMe.adapter = adapter
        rvNearMeHorizontal.adapter = adapterHorizontal
        adapter.setItemClick {
            findNavController().navigate(R.id.action_nearMeFragment_to_menuFragment)
        }
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }
}