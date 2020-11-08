package com.example.deliveryfood.ui.main.detail.model


import com.google.gson.annotations.SerializedName

data class RestourantsMenuTest(
    @SerializedName("items")
    val items: Items,
    @SerializedName("recommended")
    val recommended: List<Recommended>
)