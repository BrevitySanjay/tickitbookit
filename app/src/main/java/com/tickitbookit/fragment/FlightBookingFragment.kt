package com.tickitbookit.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.tickitbookit.R
import com.tickitbookit.databinding.FragmentFlightBookingBinding
import com.tickitbookit.databinding.FragmentHomeBinding

class FlightBookingFragment : Fragment() {

    private lateinit var binding: FragmentFlightBookingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlightBookingBinding.inflate(inflater)
        viewClick()
        changeBackground(binding.btnOneWay)
        changeCurrentFragment(TripFragment())
        return binding.root
    }

    private fun viewClick() {

        binding.imgClose.setOnClickListener {
            changeFragment(MainHomeFragment())
        }

        binding.btnOneWay.setOnClickListener {
            changeBackground(binding.btnOneWay)
            changeCurrentFragment(TripFragment())
        }

        binding.btnMultiCity.setOnClickListener { changeBackground(binding.btnMultiCity) }

        binding.btnRoundTrip.setOnClickListener { changeBackground(binding.btnRoundTrip) }

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

    private fun changeCurrentFragment(fragment : Fragment){
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.parentFragmentContainer, fragment, "")?.commit()
    }

}