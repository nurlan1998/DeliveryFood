package com.example.deliveryfood.data.models


import com.google.gson.annotations.SerializedName

data class DataRestaurant(
    @SerializedName("count")
    val count: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("restaurants")
    val restaurants: List<SingleRestaurant>
)