package com.example.deliveryfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.btm_nav_view)

        val navController = findNavController(R.id.fragment_container)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.selectedLocationFragment3,R.id.authFragment -> {
                    hideButtonNav()
                }
                else -> showButtonNav()
            }
        }

        val badge: BadgeDrawable = navView.getOrCreateBadge(R.id.alertFragment)
        badge.number = 3
        badge.isVisible = true

        val badge2: BadgeDrawable = navView.getOrCreateBadge(R.id.cartFragment)
        badge2.number = 3
        badge2.isVisible = true
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.fragment_container),
            null
        )
    }

    private fun showButtonNav() {
        btm_nav_view.visibility = View.VISIBLE
    }

    private fun hideButtonNav() {
        btm_nav_view.visibility = View.GONE
    }
}