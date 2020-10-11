package com.example.deliveryfood.ui.main.nearme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NearMeFragmentViewModel(application: Application,val repository: Repository): AndroidViewModel(application) {
    val restaurantLiveData: MutableLiveData<Response<DataRestaurant>> = MutableLiveData()

    fun getAllRestaurant() = viewModelScope.launch {
       // val response = repository.getRestaurant()
       // restaurantLiveData.value = response
    }

}