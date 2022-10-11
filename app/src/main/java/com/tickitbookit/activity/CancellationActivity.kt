package com.tickitbookit.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityCancellationBinding
import com.tickitbookit.fragment.MainHomeFragment
import com.tickitbookit.hide
import com.tickitbookit.show

class CancellationActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityCancellationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCancellationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewClick()

        binding.btnCancel.performClick()

       // changeBackground(binding.btnCancel)

    }


    private fun viewClick(){
        binding.imgClose.setOnClickListener {
            finish()
        }


        binding.btnCancel.setOnClickListener {
            binding.clCancellation.show()
            binding.clMainBaggage.hide()
            binding.tvTime3.show()
            binding.llAdult3.show()

            changeBackground(binding.btnCancel)
        }

        binding.btnDataChange.setOnClickListener {
            binding.clCancellation.show()
            binding.clMainBaggage.hide()
            binding.tvTime3.hide()
            binding.llAdult3.hide()
            changeBackground(binding.btnDataChange)
        }

        binding.btnBaggage.setOnClickListener {
            binding.clCancellation.hide()
            binding.clMainBaggage.show()
            changeBackground(binding.btnBaggage)
        }

    }

    private fun changeBackground(selectedBtn: TextView) {

        binding.btnCancel.setTextColor(Color.parseColor("#53585A"))
        binding.btnDataChange.setTextColor(Color.parseColor("#53585A"))
        binding.btnBaggage.setTextColor(Color.parseColor("#53585A"))

        binding.btnCancel.setBackgroundResource(R.drawable.round_corner_dark_gray_border)
        binding.btnDataChange.setBackgroundResource(R.drawable.round_corner_dark_gray_border)
        binding.btnBaggage.setBackgroundResource(R.drawable.round_corner_dark_gray_border)
        selectedBtn.setBackgroundResource(R.drawable.round_corner_blue_50)
        selectedBtn.setTextColor(Color.parseColor("#FFFFFF"))
    }


}