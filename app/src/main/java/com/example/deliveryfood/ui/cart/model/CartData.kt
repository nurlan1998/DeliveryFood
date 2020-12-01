package com.example.deliveryfood.ui.cart.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cart_table")
data class CartData(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("is_active")
    val isActive: Int,
    @SerializedName("is_new")
    val isNew: Int,
    @SerializedName("is_popular")
    val isPopular: Int,
    @SerializedName("is_recommended")
    val isRecommended: Int,
    @SerializedName("is_veg")
    val isVeg: Int,
    @SerializedName("item_category_id")
    val itemCategoryId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("old_price")
    val oldPrice: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("restaurant_id")
    val restaurantId: Int
)