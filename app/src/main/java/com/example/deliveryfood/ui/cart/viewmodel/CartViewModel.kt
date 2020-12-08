package com.example.deliveryfood.ui.cart.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.ui.cart.model.CartResponse
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import kotlinx.coroutines.launch
import retrofit2.Response

class CartViewModel(private val repository: Repository) : ViewModel() {

    val cartLiveData: MutableLiveData<Response<CartResponse>> = MutableLiveData()

    fun getCartCheck() = viewModelScope.launch {
        val response = repository.getCartCheck()
        cartLiveData.value = response
    }

    fun insertMenu(headlinesMenu: HeadlinesMenu) =
        viewModelScope.launch { repository.insertMenu(headlinesMenu) }

    fun deleteMenu(headlinesMenu: HeadlinesMenu) =
        viewModelScope.launch { repository.deleteMenu(headlinesMenu) }

    fun getAllProductCart() = repository.getAllProductCart()
}