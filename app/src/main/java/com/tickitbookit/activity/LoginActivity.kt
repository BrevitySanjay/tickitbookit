package com.tickitbookit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tickitbookit.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        txtSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswrodActivity::class.java))
        }
    }
}