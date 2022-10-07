package com.tickitbookit.activity

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
            promoCode()
        }

    }

    private fun fareSummary() {
        val filterBottomSheet = FareSummaryBottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(filterBottomSheet.root)
        dialog.show()

        filterBottomSheet.imgClose.setOnClickListener {
            dialog.dismiss()
        }
    }


    private fun promoCode() {
        val promoCodeBottomSheet = PromocodeBottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(promoCodeBottomSheet.root)
        dialog.show()

        searchItems.add(DummyData("350","WELCOME" ))
        searchItems.add(DummyData("350", "WELCOME"))
        Log.d(TAG, "onCreate: " + searchItems.size)
        promoCodeBottomSheet.rvPromoCodes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        promoCodeBottomSheet.rvPromoCodes.adapter = PromoCodeAdapter(searchItems,promoCodeBottomSheet.tvPromoCode)

        promoCodeBottomSheet.imgClose.setOnClickListener {
            dialog.dismiss()
        }
    }

}