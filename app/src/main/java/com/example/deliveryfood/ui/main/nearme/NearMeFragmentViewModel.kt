package com.example.deliveryfood.ui.main.nearme

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.data.models.expandable.CurrentLocation
import com.example.deliveryfood.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NearMeFragmentViewModel(application: Application, val repository: Repository) :
    AndroidViewModel(application) {
    val restaurantLiveData: MutableLiveData<Response<DataRestaurant>> = MutableLiveData()
    val locationLiveData: MutableLiveData<Response<CurrentLocation>> = MutableLiveData()

    fun getAllRestaurant(city: String, country: String) = viewModelScope.launch {
        val response = repository.getRestaurant(city, country)
        restaurantLiveData.value = response

        Log.i("jalgas", response.body().toString())
    }

    fun getCurrentLocationRestaurant() = viewModelScope.launch {
        val response = repository.getCurrentLocationRes()
        locationLiveData.value = response
    }
}