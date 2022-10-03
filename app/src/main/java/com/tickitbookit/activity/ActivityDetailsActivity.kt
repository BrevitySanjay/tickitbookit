package com.tickitbookit.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tickitbookit.R
import com.tickitbookit.adapter.CategoryAdapter
import com.tickitbookit.adapter.CategoryAdapter1
import com.tickitbookit.adapter.GalleryDetailAdapter
import com.tickitbookit.adapter.NearByAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityDetailsBinding
import com.tickitbookit.databinding.CalenderBottomSheetBinding
import com.tickitbookit.databinding.FilterBottomSheetBinding
import com.tickitbookit.databinding.ParticipantsBottomSheetBinding
import com.tickitbookit.moels.DummyData
import com.tickitbookit.utils.TAG
import com.xiaofeng.flowlayoutmanager.Alignment
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager
import java.util.*
import kotlin.collections.ArrayList

class ActivityDetailsActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val searchItems = ArrayList<DummyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchItems.add(DummyData("350", "350"))
        searchItems.add(DummyData("350", "550"))
        searchItems.add(DummyData("350", "632"))
        searchItems.add(DummyData("350", "77"))
        searchItems.add(DummyData("350", "20"))
        searchItems.add(DummyData("350", "1050"))

        binding.rvGallery.layoutManager = GridLayoutManager(this, 4)
        binding.rvGallery.adapter = GalleryDetailAdapter(searchItems)

        binding.rvNearByActivities.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvNearByActivities.adapter = NearByAdapter(searchItems)

        viewClick()
    }

    private fun viewClick() {

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.viewGalleryImages.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
        }

        binding.tvTime.setOnClickListener {
            calenderDialog()
        }
        binding.llParticipant.setOnClickListener {
            participantDialog()
        }

    }


    private fun participantDialog() {

        val filterBottomSheet = ParticipantsBottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(filterBottomSheet.root)
        dialog.show()


        filterBottomSheet.imgPlus.setOnClickListener {
            val adultnum = Integer.parseInt(filterBottomSheet.tvAdultNum.text.toString())
            Log.d(TAG, "participantDialog: " + adultnum)
            filterBottomSheet.tvAdultNum.setText(Integer.toString(adultnum + 1))
        }
        filterBottomSheet.imgMinus.setOnClickListener {
            val adultnum = Integer.parseInt(filterBottomSheet.tvAdultNum.text.toString())
            Log.d(TAG, "participantDialog: " + adultnum)
            if (adultnum != 0)
                filterBottomSheet.tvAdultNum.setText(Integer.toString(adultnum - 1))
        }

        filterBottomSheet.imgClose.setOnClickListener {
            dialog.dismiss()
        }
    }


}