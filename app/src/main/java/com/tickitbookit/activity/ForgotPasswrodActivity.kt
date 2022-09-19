package com.tickitbookit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tickitbookit.R
import com.tickitbookit.databinding.ActivityForgotPasswrodBinding
import com.tickitbookit.databinding.ActivityRegisterBinding

class ForgotPasswrodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswrodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswrodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickView()

    }

    fun clickView(){

        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}