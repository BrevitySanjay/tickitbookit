package com.tickitbookit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tickitbookit.R
import com.tickitbookit.databinding.FragmentTripBinding


class TripFragment : Fragment() {

    private lateinit var  binding : FragmentTripBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTripBinding.inflate(inflater)







        return binding.root
    }

}