package com.example.deliveryfood.ui.profile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.data.RepositoryAuthorization
import com.example.deliveryfood.ui.profile.models.LogInResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class ProfileViewModel(var repositoryAuthorization: RepositoryAuthorization) : ViewModel() {

    var signInLiveData: MutableLiveData<Response<LogInResponse>> = MutableLiveData()

    fun signIn(
        name: String,
        email: String,
        password: String,
        accessToken: String,
        phone: String,
        provider: String
    ) {
        viewModelScope.launch {
            try {
                var response = repositoryAuthorization.logIn(
                    name,
                    email,
                    password,
                    accessToken,
                    phone,
                    provider
                )
                signInLiveData.value = response
            } catch (e: Exception) {
            }
        }
    }
}