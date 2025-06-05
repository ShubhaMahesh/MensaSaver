package com.example.mensasaver

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, HomeFragment())
            .commit()

        bottomNavigation.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_account -> AccountFragment()
                R.id.nav_leftovers -> LeftoversFragment()
                R.id.nav_rewards -> RewardsFragment()
                R.id.nav_notifications -> NotificationsFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
            true
        }
    }
}