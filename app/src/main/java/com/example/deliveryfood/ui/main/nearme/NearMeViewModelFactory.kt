package com.example.deliveryfood.ui.main.nearme

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.repository.Repository

class NearMeViewModelFactory(var application: Application, val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NearMeFragmentViewModel(application, repository) as T
    }
}