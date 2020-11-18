package com.example.deliveryfood.ui.alerts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.R
import kotlinx.android.synthetic.main.fragment_alert.*

class AlertFragment : Fragment(R.layout.fragment_alert) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn.setOnClickListener {
            findNavController().navigate(R.id.action_alertFragment_to_loginFragment)
        }
    }
}