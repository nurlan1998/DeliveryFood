package com.example.deliveryfood.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.deliveryfood.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(R.layout.fragment_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandableMyAccount.parentLayout.setOnClickListener {
            if(expandableMyAccount.isExpanded){
                expandableMyAccount.collapse()
            }else{
                expandableMyAccount.expand()
            }
        }
        expandableHelp.parentLayout.setOnClickListener {
            if(expandableHelp.isExpanded){
                expandableHelp.collapse()
            }else{
                expandableHelp.expand()
            }
        }

    }
}