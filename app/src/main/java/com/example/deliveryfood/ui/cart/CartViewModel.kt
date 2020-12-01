package com.example.deliveryfood.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.ui.cart.model.CartResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class CartViewModel(private val repository: Repository): ViewModel() {

    val cartLiveData: MutableLiveData<Response<CartResponse>> = MutableLiveData()

    fun getCartCheck() = viewModelScope.launch {
        val response = repository.getCartCheck()
        cartLiveData.value = response
    }
}