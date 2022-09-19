package com.tickitbookit.activity
import android.content.Intent
import android.os.Bundle
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityRegisterBinding

class RegisterActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}