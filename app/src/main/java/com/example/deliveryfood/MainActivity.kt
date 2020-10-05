package com.example.deliveryfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //jalgas
        val navView: BottomNavigationView = findViewById(R.id.btm_nav_view)

        val navController = findNavController(R.id.fragment_container)
        navView.setupWithNavController(navController)


        val badge: BadgeDrawable = navView.getOrCreateBadge(
            R.id.alertFragment
        )
        badge.number = 3
        badge.isVisible = true

        val badge2: BadgeDrawable = navView.getOrCreateBadge(
            R.id.cartFragment
        )
        badge2.number = 3
        badge2.isVisible = true
    }
}