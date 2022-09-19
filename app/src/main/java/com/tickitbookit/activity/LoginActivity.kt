package com.tickitbookit.activity

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityLoginBinding

class LoginActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickView()

    }


    private fun clickView() {

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.llRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswrodActivity::class.java))
            finish()
        }

        binding.imgVisiblePassword.setOnClickListener {
            if (binding.edtPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                //visiblePassword.setImageResource(R.drawable.eye);
                binding.edtPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance();
            } else {
                //visiblePassword.setImageResource(R.drawable.hide);
                binding.edtPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance();
            }
        }
    }
}