package com.example.deliveryfood.ui.nearme

import android.app.Application
import androidx.lifecycle.*
import com.example.deliveryfood.data.models.Restaurants
import com.example.deliveryfood.data.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NearMeFragmentViewModel(application: Application, val repository: Repository) :
    AndroidViewModel(application) {

    val restaurantLiveData: MutableLiveData<Response<Restaurants>> = MutableLiveData()

    fun getRestaurants(latitude: String, longitude: String) = viewModelScope.launch {
        val response = repository.getCurrentLocationRes(latitude, longitude)
        restaurantLiveData.value = response
    }
}