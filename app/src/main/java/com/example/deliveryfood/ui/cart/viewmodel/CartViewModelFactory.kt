package com.example.deliveryfood.ui.cart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.data.Repository

class CartViewModelFactory(private val repository: Repository):
    ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CartViewModel(
                repository = repository
            ) as T
        }
}