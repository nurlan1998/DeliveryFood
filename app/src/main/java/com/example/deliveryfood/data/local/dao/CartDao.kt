package com.example.deliveryfood.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deliveryfood.ui.cart.model.CartData

@Dao
interface CartDao {
    @Insert
    suspend fun insert(cartData: CartData)

    @Query("SELECT COUNT (*) from cart_table")
    fun countCart(): Int
}