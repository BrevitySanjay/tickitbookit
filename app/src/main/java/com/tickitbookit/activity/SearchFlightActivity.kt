package com.tickitbookit.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tickitbookit.R
import com.tickitbookit.adapter.*
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivitySearchFlightBinding
import com.tickitbookit.databinding.FlightFilterBinding
import com.tickitbookit.databinding.NoofTravellersBottomSheetBinding
import com.tickitbookit.moels.DummyData


class SearchFlightActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivitySearchFlightBinding
    private val searchItems = ArrayList<DummyData>()
    private val searchItems1 = ArrayList<DummyData>()
    private val flightClass = ArrayList<DummyData>()
    private val noOfTraveller = ArrayList<DummyData>()
    var bottomSheetBehavior: BottomSheetBehavior<*>? = null
    private lateinit var searchFlightAdapter: SearchFlightAdapter
    private lateinit var filterClassTypeAdapter: FilterClassTypeAdapter
    private lateinit var noOfTravellerAdapter: NoOfTravellerAdapter
    private lateinit var filterBottomSheet: FlightFilterBinding


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

        searchFlightAdapter = SearchFlightAdapter(searchItems)
        binding.rvFlightList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvFlightList.adapter = searchFlightAdapter

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

        binding.edit.setOnClickListener {
            startActivity(Intent(this, CompleteBookingActivity::class.java))
        }

        searchFlightAdapter.setOnItemClickListener(object :
            SearchFlightAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                noOfTravellersBottomSheetBinding()
            }
        })
    }


    private fun filterDialog() {

        var refund = false

        filterBottomSheet = FlightFilterBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(filterBottomSheet.root)
        dialog.show()

        filterBottomSheet.imgClose.setOnClickListener {
            dialog.dismiss()
        }

        filterBottomSheet.imgRefund.setOnClickListener {
            refund = if (refund) {
                filterBottomSheet.imgRefund.setImageResource(R.drawable.ic_refund_unselect)
                false
            } else {
                filterBottomSheet.imgRefund.setImageResource(R.drawable.ic_check)
                true
            }
        }

        filterBottomSheet.llCloudy.setOnClickListener {
            selectItem(filterBottomSheet.llCloudy,filterBottomSheet.tvCloudy)
            filterBottomSheet.imgCloudy.setImageResource(R.drawable.ic_orion_partly_cloudy_white)
        }
        filterBottomSheet.llSunny.setOnClickListener {
            selectItem(filterBottomSheet.llSunny,filterBottomSheet.tvSunny)
            filterBottomSheet.imgSunny.setImageResource(R.drawable.ic_sunny_gray)
        }
        filterBottomSheet.llSunrise.setOnClickListener {
            selectItem(filterBottomSheet.llSunrise,filterBottomSheet.tvSunrise)
            filterBottomSheet.imgSunrise.setImageResource(R.drawable.ic_sunrise_white)
        }
        filterBottomSheet.llNight.setOnClickListener {
            selectItem(filterBottomSheet.llNight,filterBottomSheet.tvNight)
            filterBottomSheet.imgNight.setImageResource(R.drawable.ic_moon_white)
        }

        filterBottomSheet.rvFlightStop.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        filterBottomSheet.rvFlightStop.adapter = FilterTypeAdapter(searchItems1)

        filterBottomSheet.btnApply.setOnClickListener { dialog.dismiss() }

    }

    private fun selectItem(selectedLayout: LinearLayout,selectedText : TextView) {

        filterBottomSheet.llCloudy.setBackgroundResource(R.drawable.round_corner_gray_10)
        filterBottomSheet.llSunrise.setBackgroundResource(R.drawable.round_corner_gray_10)
        filterBottomSheet.llNight.setBackgroundResource(R.drawable.round_corner_gray_10)
        filterBottomSheet.llSunny.setBackgroundResource(R.drawable.round_corner_gray_10)

        filterBottomSheet.imgCloudy.setImageResource(R.drawable.ic_orion_partly_cloudy)
        filterBottomSheet.imgSunny.setImageResource(R.drawable.ic_sunny)
        filterBottomSheet.imgSunrise.setImageResource(R.drawable.ic_sunrise)
        filterBottomSheet.imgNight.setImageResource(R.drawable.ic_moon)

        filterBottomSheet.tvCloudy.setTextColor(Color.parseColor("#000000"))
        filterBottomSheet.tvSunny.setTextColor(Color.parseColor("#000000"))
        filterBottomSheet.tvSunrise.setTextColor(Color.parseColor("#000000"))
        filterBottomSheet.tvNight.setTextColor(Color.parseColor("#000000"))

        /** SELECTED ITEM **/
        selectedText.setTextColor(Color.parseColor("#FFFFFF"))
        selectedLayout.setBackgroundResource(R.drawable.round_corner_blue)
    }

    /** NO OF TRAVELLER DIALOG **/
    private fun noOfTravellersBottomSheetBinding() {

        val noOfTravellersBottomSheetBinding = NoofTravellersBottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(noOfTravellersBottomSheetBinding.root)
        dialog.show()

        noOfTravellersBottomSheetBinding.imgClose.setOnClickListener {
            dialog.dismiss()
        }

        flightClass.clear()
        flightClass.add(DummyData("350", "Economy"))
        flightClass.add(DummyData("350", "Premium Economy"))
        flightClass.add(DummyData("350", "Business"))
        flightClass.add(DummyData("350", "First Class"))

        filterClassTypeAdapter = FilterClassTypeAdapter(flightClass)
        noOfTravellersBottomSheetBinding.rvFlightClass.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        noOfTravellersBottomSheetBinding.rvFlightClass.adapter = filterClassTypeAdapter

        noOfTraveller.clear()
        noOfTraveller.add(DummyData("Adults", "Age 13 years and above"))
        noOfTraveller.add(DummyData("Children", "Age 12 years and below"))
        noOfTraveller.add(DummyData("Infants", "Age 0 to 2 years and below"))

        noOfTravellerAdapter = NoOfTravellerAdapter(noOfTraveller)
        noOfTravellersBottomSheetBinding.tvNoOfTraveller.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        noOfTravellersBottomSheetBinding.tvNoOfTraveller.adapter = noOfTravellerAdapter

        noOfTravellerAdapter.setOnItemClickListener(object :
            NoOfTravellerAdapter.OnItemClickListener {

            override fun onClickMinus(position: Int, tvMinus: TextView, type: String, noOfPerson: Int) {
                tvMinus.text = noOfPerson.toString()
                noOfTravellerAdapter.notifyDataSetChanged()
            }

            override fun onClickPlus(position: Int, tvPlus: TextView, type: String, person: Int) {
                tvPlus.text = person.toString()
                noOfTravellerAdapter.notifyDataSetChanged()
            }
        })

        noOfTravellersBottomSheetBinding.btnBookNow.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this,CompleteBookingActivity::class.java))
        }

    }
}