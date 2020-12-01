package com.example.deliveryfood

import android.app.Application
import androidx.room.Room
import com.example.deliveryfood.data.local.AppRoomDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this

        database = Room.databaseBuilder(this, AppRoomDatabase::class.java, "cart_db")
            .build()
    }

    companion object {
        private var instance: App? = null
        private var database: AppRoomDatabase? = null

        fun getInstance(): App {
            return instance!!
        }

        fun getDatabase(): AppRoomDatabase {
            return database!!
        }
    }
}