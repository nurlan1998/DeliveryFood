package com.example.deliveryfood.data

import androidx.lifecycle.LiveData
import com.example.deliveryfood.App
import com.example.deliveryfood.data.models.DetailRestaurant
import com.example.deliveryfood.data.models.Restaurants
import com.example.deliveryfood.data.network.RetrofitInstance
import com.example.deliveryfood.ui.cart.model.CartResponse
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import com.example.deliveryfood.ui.menu.model.MenuResponse
import retrofit2.Response

class Repository {

    suspend fun getCurrentLocationRes(latitude: String, longitude: String): Response<Restaurants> {
        return RetrofitInstance.api.postLocation(latitude, longitude)
    }

    suspend fun getDetailRestaurant(id: Int): Response<DetailRestaurant> {
        return RetrofitInstance.api.restaurantDetailById(id)
    }

    suspend fun getCartCheck(): Response<CartResponse> {
        return RetrofitInstance.api.getCartCheck()
    }

    suspend fun getMenuRestaurant(slug: String): Response<MenuResponse> {
        return RetrofitInstance.api.restaurantMenu(slug = slug)
    }

    suspend fun insertMenu(headlinesMenu: HeadlinesMenu) =
        App.getDatabase().getMenuDao().insertMenu(headlinesMenu)

    suspend fun deleteMenu(headlinesMenu: HeadlinesMenu) =
        App.getDatabase().getMenuDao().deleteMenu(headlinesMenu)

    fun getCountCart(): LiveData<Int> = App.getDatabase().getMenuDao().countCart()
}