package com.example.deliveryfood.ui.main.detail.model


import com.google.gson.annotations.SerializedName

data class AddonCategoryXX(
    @SerializedName("addons")
    val addons: List<Any>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("pivot")
    val pivot: PivotXX,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)