package com.tickitbookit.activity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityMainBinding
import com.tickitbookit.fragment.MainHomeFragment

class MainActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.content, MainHomeFragment(), "")
            .commit()

        //bottomNavigation.itemIconTintList = null
        binding.bottomNavigation.setOnNavigationItemSelectedListener(selectedListener);

    }


    private val selectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content, MainHomeFragment(), "HOME").commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favourite -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trips -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}