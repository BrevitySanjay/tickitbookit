package com.tickitbookit.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.fragment.HomeFragment
import com.tickitbookit.fragment.MainHomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : CustomAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigation.itemIconTintList = null
        bottomNavigation.setOnNavigationItemSelectedListener(selectedListener);

        supportFragmentManager.beginTransaction().replace(R.id.content, MainHomeFragment(), "").commit()


    }


    private val selectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, MainHomeFragment(), "").commit()
                    return@OnNavigationItemSelectedListener true
                }

                /*R.id.favourite -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trips -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    return@OnNavigationItemSelectedListener true
                }*/
            }
            false
        }
}