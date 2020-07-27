package com.project.interin_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.interin_app.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = findNavController(R.id.as_nav_host).apply {}
        findViewById<BottomNavigationView>(R.id.am_navigation).setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_user_profile -> {
                    navController.navigate(R.id.action_global_user_ProfileFragment)
                    true
                }
                R.id.menu_sign_up -> {
                    navController.navigate(R.id.action_global_med_institutionFragment)
                    true
                }
                R.id.menu_user_records -> {
                    navController.navigate(R.id.action_global_user_RecordsFragment)
                    true
                }
                else -> false
            }
        }
    }
}
