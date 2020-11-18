package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class AddonCategoryX(
    @SerializedName("addons")
    val addons: List<AddonX>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("pivot")
    val pivot: PivotX,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)