package com.example.deliveryfood.ui.main.nearme

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.R
import com.example.deliveryfood.repository.Repository
import kotlinx.android.synthetic.main.fragment_near_me.*

class NearMeFragment : Fragment(R.layout.fragment_near_me) {

    private lateinit var mNearMeFragmentViewModel: NearMeFragmentViewModel
    private lateinit var mNearMeViewModelFactory: NearMeViewModelFactory
    private lateinit var adapter: NearMeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        init()

        mNearMeFragmentViewModel.restaurantLiveData.observe(requireActivity(), Observer {
            if (it.isSuccessful) {
                Log.i("jalgas2", it.body()?.restaurants.toString())
                val result = it.body()?.restaurants
                if (result != null) {
                    adapter.models = result
                }
            }
        })
    }

    private fun init() {
        val repository = Repository()
        mNearMeViewModelFactory = NearMeViewModelFactory(Application(), repository)
        mNearMeFragmentViewModel = ViewModelProvider(this, mNearMeViewModelFactory)
            .get(NearMeFragmentViewModel::class.java)
        mNearMeFragmentViewModel.getAllRestaurant(city = " ", country = "AW")
    }

    private fun setRecyclerView() {
        adapter = NearMeAdapter()
        rvNearMe.adapter = adapter
        adapter.setItemClick {
            findNavController().navigate(R.id.action_nearMeFragment_to_detailFragment)
        }
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }
}