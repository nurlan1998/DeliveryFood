package com.example.deliveryfood.ui.main.nearme

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.R
import com.example.deliveryfood.repository.Repository

class NearMeFragment : Fragment(R.layout.fragment_near_me) {

    private lateinit var mNearMeFragmentViewModel:NearMeFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var repository = Repository()
        var NearMeViewModelFactory = NearMeViewModelFactory(Application(), repository)
        mNearMeFragmentViewModel = ViewModelProvider(this, NearMeViewModelFactory).get(NearMeFragmentViewModel::class.java)

        mNearMeFragmentViewModel.getAllRestaurant(city = " ",country = "AW")
        mNearMeFragmentViewModel.restaurantLiveData.observe(requireActivity(), Observer {
            if (it.isSuccessful) {
                Log.i("jalgas2",it.body()?.restaurants.toString())
            }
        })
    }
}