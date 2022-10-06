package com.tickitbookit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.adapter.BookingListAdapter
import com.tickitbookit.adapter.SearchItemAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityCompleteBookingBinding
import com.tickitbookit.moels.DummyData

class CompleteBookingActivity : CustomAppCompatActivity() {

    private val searchItems = ArrayList<DummyData>()
    private lateinit var binding: ActivityCompleteBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompleteBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewClick()

        searchItems.add(DummyData("350", "350"))
        searchItems.add(DummyData("350", "550"))
        searchItems.add(DummyData("350", "632"))
        searchItems.add(DummyData("350", "77"))
        searchItems.add(DummyData("350", "20"))
        searchItems.add(DummyData("350", "1050"))

        binding.rvBookingList.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvBookingList.adapter = BookingListAdapter(searchItems)

    }

    private fun viewClick() {

        binding.back.setOnClickListener { finish() }

        binding.clApplyPromo.setOnClickListener {}

        binding.btnBookNow.setOnClickListener {
            startActivity(Intent(this, AddTravellerActivity::class.java))
        }
    }
}