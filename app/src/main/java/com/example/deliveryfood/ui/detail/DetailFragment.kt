package com.example.deliveryfood.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.other.Constants
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailViewModelFactory: DetailViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        detailViewModel.detailLiveData.observe(viewLifecycleOwner, Observer {
            tvDetailTitle.text = it.body()?.name
            tvDetailPrice.text = "$" + it.body()?.priceRange

            Glide.with(requireContext()).load(Constants.BASE_URL + it.body()?.image)
                .into(ivDetailMovie)
        })
    }

    private fun init() {
        val repository = Repository()
        detailViewModelFactory = DetailViewModelFactory(repository = repository)
        detailViewModel = ViewModelProvider(this,detailViewModelFactory).get(DetailViewModel::class.java)
        detailViewModel.getDetailRestaurant(1)
    }
}