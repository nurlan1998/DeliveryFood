package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class Pivot(
    @SerializedName("addon_category_id")
    val addonCategoryId: Int,
    @SerializedName("item_id")
    val itemId: Int
)