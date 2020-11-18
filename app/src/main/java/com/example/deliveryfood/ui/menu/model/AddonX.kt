package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class AddonX(
    @SerializedName("addon_category_id")
    val addonCategoryId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_active")
    val isActive: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)