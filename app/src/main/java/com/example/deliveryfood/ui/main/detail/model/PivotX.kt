package com.example.deliveryfood.ui.main.detail.model


import com.google.gson.annotations.SerializedName

data class PivotX(
    @SerializedName("addon_category_id")
    val addonCategoryId: Int,
    @SerializedName("item_id")
    val itemId: Int
)