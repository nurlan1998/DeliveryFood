package com.example.deliveryfood.ui.nearme.view

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
import com.example.deliveryfood.adapters.HorizontalAdapter
import com.example.deliveryfood.adapters.OnItemClick
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.ui.nearme.viewmodel.NearMeViewModel
import com.example.deliveryfood.ui.nearme.viewmodel.NearMeViewModelFactory
import kotlinx.android.synthetic.main.fragment_near_me.*

class NearMeFragment : Fragment(R.layout.fragment_near_me) {

    private lateinit var mNearMeFragmentViewModel: NearMeViewModel
    private lateinit var mNearMeViewModelFactory: NearMeViewModelFactory
    private lateinit var adapter: NearMeAdapter
    private lateinit var horizontalAdapter: HorizontalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        initialize()
        setupData()

//        mNearMeFragmentViewModel.startViewModel()
//
//        mNearMeFragmentViewModel.restaurantLiveData.observe(requireActivity(), Observer {
//            adapter.models = it
//            adapterHorizontal.horizontalModel = it
//        })
//
    }

    private fun setupData() {
        mNearMeFragmentViewModel.getRestaurants("41.311081", "69.240562")
        mNearMeFragmentViewModel.restaurantLiveData.observe(requireActivity(), Observer {
            val restaurantsList = it.body()?.toList()
            Log.i("Res", restaurantsList.toString())
            if (restaurantsList != null) {
                adapter.models = restaurantsList
            }
        })

        mNearMeFragmentViewModel.getSliderData()
        mNearMeFragmentViewModel.sliderLiveData.observe(viewLifecycleOwner, Observer {
            val sliderResponse = it.body()?.mainSlides?.toList()
            if (sliderResponse != null) {
                horizontalAdapter.models = sliderResponse
                Log.i("Result", sliderResponse.toString())
            }
        })
    }

    private fun initialize() {
        val repository = Repository()
        mNearMeViewModelFactory = NearMeViewModelFactory(Application(), repository)
        mNearMeFragmentViewModel =
            ViewModelProvider(this, mNearMeViewModelFactory).get(NearMeViewModel::class.java)
    }

    private fun setupRecyclerView() {
        adapter = NearMeAdapter()
        horizontalAdapter = HorizontalAdapter()
        rvNearMe.adapter = adapter
        rvHorizontal.adapter = horizontalAdapter
        adapter.setItemClick {
            var id: Int = it.id
            var image: String = it.image
            var name: String = it.name
            var typeFood: String = it.description
            var rating: String = it.rating
            var times: String = it.deliveryTime
            var price: String = it.priceRange
            val action = NearMeFragmentDirections.actionNearMeFragmentToMenuFragment(
                id = id,
                imageRestaurant = image,
                titleRestaurant = name,
                typeFood = typeFood,
                timeRestaurant = times,
                ratingRestaurant = rating,
                priceRestaurant = price
            )
            findNavController().navigate(action)
        }
        horizontalAdapter.setItemClick {
            var idSlider = it.id
            var image: String = it.image
            var name: String = it.name
            var typeFood: String = ""
            var rating: String = ""
            var times: String = ""
            var price: String = ""
            val action = NearMeFragmentDirections.actionNearMeFragmentToMenuFragment(
                id = idSlider,
                imageRestaurant = image,
                titleRestaurant = name,
                typeFood = typeFood,
                timeRestaurant = times,
                ratingRestaurant = rating,
                priceRestaurant = price
            )
            findNavController().navigate(action)
        }
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }
}