package com.example.deliveryfood.ui.cart

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.R
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.ui.nearme.NearMeViewModel
import com.example.deliveryfood.ui.nearme.NearMeViewModelFactory

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var cartViewModel: CartViewModel
    private lateinit var cartViewModelFactory: CartViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        cartViewModelFactory = CartViewModelFactory(repository)
        cartViewModel = ViewModelProvider(this, cartViewModelFactory)
            .get(CartViewModel::class.java)
        cartViewModel.getCartCheck()

        cartViewModel.cartLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("Cart",it.body()?.items?.toList().toString())
        })
    }
}