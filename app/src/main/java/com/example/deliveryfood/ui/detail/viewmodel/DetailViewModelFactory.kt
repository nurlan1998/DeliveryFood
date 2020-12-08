package com.example.deliveryfood.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.data.Repository

class DetailViewModelFactory(val repository: Repository):
    ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DetailViewModel(
                repository
            ) as T
        }
}