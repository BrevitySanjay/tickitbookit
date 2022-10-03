package com.tickitbookit.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tickitbookit.R
import com.tickitbookit.activity.SearchFlightActivity
import com.tickitbookit.classes.CustomFragment
import com.tickitbookit.databinding.FragmentFlightBookingBinding
import com.tickitbookit.hide
import com.tickitbookit.show

class FlightBookingFragment(context : Activity) : CustomFragment(context) {

    private lateinit var binding: FragmentFlightBookingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFlightBookingBinding.inflate(inflater)
        viewClick()
        changeBackground(binding.btnOneWay)
        return binding.root
    }

    private fun viewClick() {

        binding.imgClose.setOnClickListener {
            changeFragment(MainHomeFragment())
        }

        binding.btnOneWay.setOnClickListener {
            binding.tvRoundTripDate.hide()
            binding.tvAddReturnDate.show()
            binding.CTextViewLight.show()
            binding.parentFragment.hide()
            changeBackground(binding.btnOneWay)
        }

        binding.btnMultiCity.setOnClickListener {
            changeCurrentFragment(MultiCityFragment(context as Activity))
            binding.parentFragment.show()
            changeBackground(binding.btnMultiCity)
        }

        binding.btnRoundTrip.setOnClickListener {
            binding.tvRoundTripDate.show()
            binding.tvAddReturnDate.hide()
            binding.CTextViewLight.hide()
            binding.parentFragment.hide()
            changeBackground(binding.btnRoundTrip)
        }

        binding.constraintLayout4.setOnClickListener {
            binding.btnRoundTrip.performClick()
            binding.tvRoundTripDate.show()
            binding.tvAddReturnDate.hide()
            binding.CTextViewLight.hide()
        }

        binding.tvRoundTripDate.setOnClickListener {
            calenderDialog()
        }

        binding.tvFlightDate.setOnClickListener {
            calenderDialog()
        }

        binding.btnSearchFlight.setOnClickListener { startActivity(Intent(context,SearchFlightActivity::class.java)) }

    }

    private fun changeBackground(selectedBtn: TextView) {

        binding.btnOneWay.setTextColor(Color.parseColor("#53585A"))
        binding.btnMultiCity.setTextColor(Color.parseColor("#53585A"))
        binding.btnRoundTrip.setTextColor(Color.parseColor("#53585A"))

        binding.btnOneWay.setBackgroundResource(R.drawable.round_corner_dark_gray_border)
        binding.btnMultiCity.setBackgroundResource(R.drawable.round_corner_dark_gray_border)
        binding.btnRoundTrip.setBackgroundResource(R.drawable.round_corner_dark_gray_border)
        selectedBtn.setBackgroundResource(R.drawable.round_corner_blue_50)
        selectedBtn.setTextColor(Color.parseColor("#FFFFFF"))
    }

    private fun changeFragment(fragment: Fragment) {
        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
        ft.replace(R.id.content, fragment, "NewFragmentTag")
        ft.commit()
    }

    private fun changeCurrentFragment(fragment: Fragment) {
        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
        ft.replace(R.id.parentFragment, fragment, "NewFragmentTag")
        ft.commit()
    }
}