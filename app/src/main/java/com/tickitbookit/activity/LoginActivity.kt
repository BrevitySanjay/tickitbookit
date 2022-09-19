package com.tickitbookit.activity

import android.content.Intent
import android.os.Bundle
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityLoginBinding

class LoginActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.llRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }

        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this,GalleryActivity::class.java))
            finish()
        }

    }
}