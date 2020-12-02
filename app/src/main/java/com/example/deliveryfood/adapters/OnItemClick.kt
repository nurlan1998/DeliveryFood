package com.example.deliveryfood.adapters

import com.example.deliveryfood.ui.menu.model.HeadlinesMenu

interface OnItemClick {
    fun deleteCart(headlinesMenu: HeadlinesMenu)
    fun addCard(headlinesMenu: HeadlinesMenu)
}