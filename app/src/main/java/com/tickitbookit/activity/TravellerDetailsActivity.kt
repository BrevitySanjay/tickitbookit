package com.tickitbookit.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tickitbookit.R
import com.tickitbookit.adapter.PromoCodeAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityTravellerDetailsBinding
import com.tickitbookit.databinding.FareSummaryBottomSheetBinding
import com.tickitbookit.databinding.PromocodeBottomSheetBinding
import com.tickitbookit.moels.DummyData
import com.tickitbookit.moels.DummyData_3
import com.tickitbookit.utils.TAG

class TravellerDetailsActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityTravellerDetailsBinding
    private val searchItems = ArrayList<DummyData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTravellerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            fareSummary()
        }

    }

    private fun fareSummary() {
        val fareSummaryBottomSheetBinding = FareSummaryBottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(fareSummaryBottomSheetBinding.root)
        dialog.show()

        fareSummaryBottomSheetBinding.imgClose.setOnClickListener {
            dialog.dismiss()
        }

        fareSummaryBottomSheetBinding.btnContinue.setOnClickListener {
            startActivity(Intent(this,CardDetailsActivity::class.java))
        }


    }

}