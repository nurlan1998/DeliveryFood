package com.example.deliveryfood.ui.nearme.viewmodel

import androidx.lifecycle.*
import com.example.deliveryfood.ui.nearme.models.RestaurantData
import com.example.deliveryfood.data.Repository
import com.example.deliveryfood.ui.nearme.models.RestaurantResponse
import com.example.deliveryfood.ui.nearme.models.SliderResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class NearMeViewModel(private val repository: Repository) : ViewModel() {

    val restaurantLiveData: MutableLiveData<Response<RestaurantData>> = MutableLiveData()
    val sliderLiveData: MutableLiveData<Response<SliderResponse>> = MutableLiveData()
//    var restaurantLiveData: MutableLiveData<List<RestaurantsItem>> = MutableLiveData()

    fun getRestaurants(latitude: String, longitude: String) = viewModelScope.launch {
        val response = repository.getCurrentLocationRes(latitude, longitude)
        restaurantLiveData.value = response
    }

    fun getSliderData() = viewModelScope.launch {
        val response = repository.getSliderData()
        sliderLiveData.value = response
    }

    fun startViewModel() {

        val members = mutableListOf<RestaurantResponse>()

        for (i in 0..20) {
            if (i == 0) {
                val member =
                    RestaurantResponse(
                        id = 0,
                        deliveryTime = "4",
                        description = "У нас все вкусное",
                        image = "https://media-cdn.tripadvisor.com/media/photo-s/17/d8/ee/ea/photo0jpg.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Ресторан Neo",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
            if (i == 1) {
                val member =
                    RestaurantResponse(
                        id = 1,
                        deliveryTime = "4",
                        description = "Японская, Пицца",
                        image = "https://media-cdn.tripadvisor.com/media/photo-s/0d/71/fb/0d/getlstd-property-photo.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Cinnamon Coffee & Pastry",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
            if (i == 2) {
                val member =
                    RestaurantResponse(
                        id = 1,
                        deliveryTime = "4",
                        description = "Международная",
                        image = "https://media-cdn.tripadvisor.com/media/photo-s/08/18/d5/7c/sheraton-cafe.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Sheraton Cafe",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
            if (i == 3) {
                val member =
                    RestaurantResponse(
                        id = 1,
                        deliveryTime = "4",
                        description = "Европейская",
                        image = "https://media-cdn.tripadvisor.com/media/photo-s/19/83/8f/1e/caption.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Premier Lounge",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
            if (i == 4) {
                val member =
                    RestaurantResponse(
                        id = 1,
                        deliveryTime = "4",
                        description = "Бар, Паб",
                        image = "https://media-cdn.tripadvisor.com/media/photo-p/1a/03/85/e3/caption.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Bellagio",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
            if (i == 5) {
                val member =
                    RestaurantResponse(
                        id = 1,
                        deliveryTime = "4",
                        description = "Центральноазиатская, Европейская",
                        image = "https://media-cdn.tripadvisor.com/media/photo-s/1a/55/0d/67/asiana-restaurant-bar.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Ресторан Asiana",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
            if (i == 5) {
                val member =
                    RestaurantResponse(
                        id = 1,
                        deliveryTime = "4",
                        description = "Узбекская",
                        image = "https://media-cdn.tripadvisor.com/media/photo-s/17/fa/04/35/photo0jpg.jpg",
                        isActive = 3,
                        isFeatured = 4,
                        name = "Las Vegas",
                        priceRange = "150 000",
                        rating = "5",
                        slug = "qwertty"
                    )
                members.add(member)
            }
        }
//            restaurantLiveData.value = members
    }
}