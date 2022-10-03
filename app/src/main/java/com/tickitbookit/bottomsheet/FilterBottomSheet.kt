package com.tickitbookit.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tickitbookit.R
import com.tickitbookit.databinding.FlightFilterBinding
import com.tickitbookit.databinding.FragmentHomeBinding

class FilterBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FlightFilterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FlightFilterBinding.inflate(inflater)



        return binding.root
    }
}