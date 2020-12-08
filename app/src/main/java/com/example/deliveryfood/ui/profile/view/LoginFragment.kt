package com.example.deliveryfood.ui.profile.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryfood.R
import com.example.deliveryfood.data.RepositoryAuthorization
import com.example.deliveryfood.ui.profile.viewmodel.ProfileFactory
import com.example.deliveryfood.ui.profile.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var profileFactory: ProfileFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            init()
        }
    }

    private fun init() {
        var repositoryAuthorization = RepositoryAuthorization()

        profileFactory = ProfileFactory(repositoryAuthorization)

        profileViewModel = ViewModelProvider(requireActivity(), profileFactory).get(ProfileViewModel::class.java)

        profileViewModel.signIn("", "test@gmail.com", "12345", "", "", "")

        profileViewModel.signInLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("SignIn", it.body()?.data.toString())
        })

    }
}