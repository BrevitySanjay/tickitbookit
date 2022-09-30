package com.tickitbookit.activity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityMainBinding
import com.tickitbookit.fragment.MainHomeFragment

class MainActivity : CustomAppCompatActivity() {

    /** CREATED BY SANJAY DAMOR Mon Sep 12 16:52:50 IST 2022 **/

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainHomeFragment : MainHomeFragment

    /** CREATE NEW BRANCH **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainHomeFragment = MainHomeFragment()

        defaultFragment()

        //bottomNavigation.itemIconTintList = null
        binding.bottomNavigation.setOnNavigationItemSelectedListener(selectedListener);

    }


    private fun defaultFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.content, mainHomeFragment, "").commit()
    }

    private val selectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    defaultFragment()
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

    override fun onBackPressed() {
        if (!mainHomeFragment.isAdded){
            defaultFragment()
        }else{
            finish()
        }
    }
}