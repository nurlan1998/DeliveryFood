package com.example.deliveryfood.ui.cart.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.App
import com.example.deliveryfood.R
import com.example.deliveryfood.adapters.CartAdapter
import com.example.deliveryfood.adapters.OnItemClick
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.data.local.AppRoomDatabase
import com.example.deliveryfood.data.local.dao.MenuDao
import com.example.deliveryfood.ui.cart.viewmodel.CartViewModel
import com.example.deliveryfood.ui.cart.viewmodel.CartViewModelFactory
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var cartViewModel: CartViewModel
    private lateinit var cartViewModelFactory: CartViewModelFactory
    private lateinit var db: AppRoomDatabase
    private lateinit var cartDao: MenuDao
    private lateinit var cartAdapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupRecyclerView()

        cartViewModel.getCartCheck()
        cartViewModel.cartLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("Cart", it.body()?.items?.toList().toString())
        })
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter()
        rvCart.adapter = cartAdapter
        cartViewModel.getAllProductCart().observe(viewLifecycleOwner, Observer {
            cartAdapter.models = it
        })
        cartAdapter.setOnItemClickHeadline(object : OnItemClick {
            override fun deleteCart(headlinesMenu: HeadlinesMenu) {
                cartViewModel.deleteMenu(headlinesMenu)
            }

            override fun addCard(headlinesMenu: HeadlinesMenu) {
                cartViewModel.insertMenu(headlinesMenu)
            }
        })
    }

    private fun init() {
        val repository = Repository()
        cartViewModelFactory =
            CartViewModelFactory(
                repository
            )
        cartViewModel = ViewModelProvider(this, cartViewModelFactory)
            .get(CartViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        db = App.getDatabase()
        cartDao = db.getMenuDao()
    }
}