package com.example.deliveryfood.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenu(headlinesMenu: HeadlinesMenu)

    @Delete
    suspend fun deleteMenu(headlinesMenu: HeadlinesMenu)

    @Query("SELECT COUNT(*) FROM menu_table")
    fun countCart(): LiveData<Int>

    @Query("SELECT * FROM menu_table")
    fun getAllProductCart(): LiveData<List<HeadlinesMenu>>
}