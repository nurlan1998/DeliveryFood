package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class RestourantsMenuTest(
    @SerializedName("items")
    val items: List<NewsPaperModel>,
    @SerializedName("recommended")
    val recommended: List<Recommended>
)