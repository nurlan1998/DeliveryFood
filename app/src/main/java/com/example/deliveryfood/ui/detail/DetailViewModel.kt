package com.example.deliveryfood.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.data.models.DetailRestaurant
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel(private val repository: Repository): ViewModel() {

    val detailLiveData: MutableLiveData<Response<DetailRestaurant>> = MutableLiveData()

    fun getDetailRestaurant(id: Int){
        viewModelScope.launch {
            val response = repository.getDetailRestaurant(id)
            detailLiveData.value = response
        }
    }
}