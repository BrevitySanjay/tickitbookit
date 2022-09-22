package com.tickitbookit.activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityRegisterBinding

class RegisterActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        clickView()

    }


    private fun clickView(){

        binding.llLogin.setOnClickListener { finish() }

        binding.imgBack.setOnClickListener { finish() }


        binding.passwordVisible.setOnClickListener {
            if (binding.edtPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                //passwordVisible.setImageResource(R.drawable.eye);
                binding.edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance();
            } else {
                //visiblePassword.setImageResource(R.drawable.hide);
                binding.edtPassword.transformationMethod = PasswordTransformationMethod.getInstance();
            }
        }

        binding.confirmPasswordVisible.setOnClickListener {
            if (binding.edtConfirmPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                //visiblePassword.setImageResource(R.drawable.eye);
                binding.edtConfirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance();
            } else {
                //visiblePassword.setImageResource(R.drawable.hide);
                binding.edtConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance();
            }
        }
    }
}