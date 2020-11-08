package com.example.deliveryfood.ui.main.detail.model


import com.google.gson.annotations.SerializedName

data class Nonushta(
    @SerializedName("addon_categories")
    val addonCategories: List<AddonCategory>,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("desc")
    val desc: String,
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
    @SerializedName("placeholder_image")
    val placeholderImage: Any,
    @SerializedName("price")
    val price: String,
    @SerializedName("restaurant_id")
    val restaurantId: Int
)