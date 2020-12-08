package com.example.deliveryfood.ui.nearme.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.data.Repository

class NearMeViewModelFactory(var application: Application, val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NearMeViewModel(
            repository
        ) as T
    }
}