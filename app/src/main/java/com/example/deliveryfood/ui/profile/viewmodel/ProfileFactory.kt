package com.example.deliveryfood.ui.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.data.RepositoryAuthorization

class ProfileFactory(val repositoryAuthorization: RepositoryAuthorization) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            repositoryAuthorization
        ) as T
    }
}