package com.tickitbookit.activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tickitbookit.adapter.FilterTypeAdapter
import com.tickitbookit.adapter.MonthDayAdapter
import com.tickitbookit.adapter.SearchFlightAdapter
import com.tickitbookit.bottomsheet.FilterBottomSheet
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivitySearchFlightBinding
import com.tickitbookit.databinding.FlightFilterBinding
import com.tickitbookit.moels.DummyData


class SearchFlightActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivitySearchFlightBinding
    private val searchItems = ArrayList<DummyData>()
    private val searchItems1 = ArrayList<DummyData>()
    var bottomSheetBehavior: BottomSheetBehavior<*>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchFlightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchItems.add(DummyData("350", "350"))
        searchItems.add(DummyData("350", "550"))
        searchItems.add(DummyData("350", "632"))
        searchItems.add(DummyData("350", "77"))
        searchItems.add(DummyData("350", "20"))
        searchItems.add(DummyData("350", "1050"))

        binding.rvFlightList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvFlightList.adapter = SearchFlightAdapter(searchItems)

        binding.rvMonthDay.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvMonthDay.adapter = MonthDayAdapter(searchItems)

        searchItems1.add(DummyData("350", "Non Stop"))
        searchItems1.add(DummyData("350", "1 Stop"))
        searchItems1.add(DummyData("350", "2 Stop"))
        searchItems1.add(DummyData("350", "3 Stop"))
        
        viewClick()

    }

    private fun viewClick() {

        binding.back.setOnClickListener { finish() }
        binding.btnFilter.setOnClickListener { filterDialog() }

    }

    private fun filterDialog() {

        val filterBottomSheet = FlightFilterBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, com.tickitbookit.R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(filterBottomSheet.root)
        dialog.show()

        filterBottomSheet.imgClose.setOnClickListener {
            dialog.dismiss()
        }

        filterBottomSheet.imgRefund.setOnClickListener {

        }

        filterBottomSheet.rvFlightStop.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        filterBottomSheet.rvFlightStop.adapter = FilterTypeAdapter(searchItems1)

    }
}