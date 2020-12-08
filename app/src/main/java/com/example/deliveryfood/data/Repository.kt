package com.example.deliveryfood.data

import androidx.lifecycle.LiveData
import com.example.deliveryfood.App
import com.example.deliveryfood.ui.detail.models.DetailResponse
import com.example.deliveryfood.ui.nearme.models.RestaurantData
import com.example.deliveryfood.data.network.RetrofitInstance
import com.example.deliveryfood.ui.cart.model.CartResponse
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import com.example.deliveryfood.ui.menu.model.MenuResponse
import com.example.deliveryfood.ui.nearme.models.SliderResponse
import retrofit2.Response

class Repository {

    suspend fun getCurrentLocationRes(latitude: String, longitude: String): Response<RestaurantData> {
        return RetrofitInstance.api.postLocation(latitude, longitude)
    }

    suspend fun getSliderData(): Response<SliderResponse> {
        return RetrofitInstance.api.getSliderData()
    }

    suspend fun getDetailRestaurant(id: Int): Response<DetailResponse> {
        return RetrofitInstance.api.restaurantDetailById(id)
    }

    suspend fun getCartCheck(): Response<CartResponse> {
        return RetrofitInstance.api.getCartCheck()
    }

    suspend fun getMenuRestaurant(id:Int): Response<MenuResponse> {
        return RetrofitInstance.api.restaurantMenu(id = id)
    }

    suspend fun insertMenu(headlinesMenu: HeadlinesMenu) =
        App.getDatabase().getMenuDao().insertMenu(headlinesMenu)

    suspend fun deleteMenu(headlinesMenu: HeadlinesMenu) =
        App.getDatabase().getMenuDao().deleteMenu(headlinesMenu)

    fun getCountCart(): LiveData<Int> = App.getDatabase().getMenuDao().countCart()
    fun getAllProductCart() = App.getDatabase().getMenuDao().getAllProductCart()
}