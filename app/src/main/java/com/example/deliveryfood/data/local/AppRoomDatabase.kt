package com.example.deliveryfood.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deliveryfood.data.local.dao.MenuDao
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu

@Database(entities = [HeadlinesMenu::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getMenuDao(): MenuDao
}