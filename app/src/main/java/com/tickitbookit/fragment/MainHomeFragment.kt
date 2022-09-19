package com.tickitbookit.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tickitbookit.R
import com.tickitbookit.adapter.DestinationItemAdapter
import com.tickitbookit.databinding.FragmentMainHomeBinding
import com.tickitbookit.moels.DummyData


class MainHomeFragment : Fragment() {


    private lateinit var binding: FragmentMainHomeBinding

    private val searchItems = ArrayList<DummyData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentMainHomeBinding.inflate(layoutInflater)

        //val view: View = inflater.inflate(R.layout.fragment_main_home, container, false)

        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))

        binding.rvDestination.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        binding.rvDestination.adapter = DestinationItemAdapter(searchItems)


        binding.btnSearch.setOnClickListener {
            val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
            ft.replace(R.id.content, HomeFragment(), "NewFragmentTag")
            ft.commit()
        }

        binding.tabActivity.setOnClickListener {
            selectTab(binding.tabActivity)
        }

        binding.tabFlights.setOnClickListener {
            selectTab(binding.tabFlights)
        }

        binding.tabHotels.setOnClickListener {
            selectTab(binding.tabHotels)
        }

        return binding.root
    }



    private fun selectTab(text : TextView){

        binding.tabActivity.setTextColor(Color.parseColor("#53585A"));
        binding.tabFlights.setTextColor(Color.parseColor("#53585A"));
        binding.tabHotels.setTextColor(Color.parseColor("#53585A"));
        binding.tabActivity.setBackgroundResource(0)
        binding.tabFlights.setBackgroundResource(0)
        binding.tabHotels.setBackgroundResource(0)

        text.setTextColor(Color.parseColor("#FFFFFF"));
        text.setBackgroundResource(R.drawable.round_corner_blue_50)
    }

}
