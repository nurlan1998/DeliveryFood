package com.example.deliveryfood.ui.main.nearme

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NearMeFragmentViewModel(application: Application,val repository: Repository): AndroidViewModel(application) {
    val restaurantLiveData: MutableLiveData<Response<DataRestaurant>> = MutableLiveData()

    fun getAllRestaurant(price:Int,name:String,address:String) = viewModelScope.launch {
        val response = repository.getRestaurant(price,name, address)
        restaurantLiveData.value = response

        Log.e("jalgas",response.body().toString())
    }

}