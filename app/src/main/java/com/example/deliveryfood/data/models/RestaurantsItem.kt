package com.example.deliveryfood.data.models


import com.google.gson.annotations.SerializedName

data class RestaurantsItem(
    @SerializedName("delivery_time")
    val deliveryTime: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("is_active")
    val isActive: Int,
    @SerializedName("is_featured")
    val isFeatured: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_range")
    val priceRange: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("slug")
    val slug: String
)