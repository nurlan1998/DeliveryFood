package com.example.deliveryfood.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deliveryfood.data.local.dao.CartDao
import com.example.deliveryfood.ui.cart.model.CartData

@Database(entities = [CartData::class],version = 1,exportSchema = false)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun getCartDao(): CartDao
}