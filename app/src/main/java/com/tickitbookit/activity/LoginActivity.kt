package com.tickitbookit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : CustomAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        llRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }

        tvForgotPassword.setOnClickListener {
            startActivity(Intent(this,GalleryActivity::class.java))
            finish()
        }

    }
}