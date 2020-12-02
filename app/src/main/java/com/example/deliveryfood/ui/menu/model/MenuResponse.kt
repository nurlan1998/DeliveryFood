package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class MenuResponse(
    @SerializedName("items")
    val newsPaperMenu: List<NewsPaperMenu>,
    @SerializedName("recommended")
    val recommended: List<Recommended>
)