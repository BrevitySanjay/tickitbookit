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
import com.tickitbookit.moels.DummyData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_main_home.*
import kotlinx.android.synthetic.main.fragment_main_home.view.*


class MainHomeFragment : Fragment() {

    private val searchItems = ArrayList<DummyData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_main_home, container, false)

        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))

        view.rvDestination.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        view.rvDestination.adapter = DestinationItemAdapter(searchItems)


        view.btnSearch.setOnClickListener {
            val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
            ft.replace(R.id.content, HomeFragment(), "NewFragmentTag")
            ft.commit()
        }

        view.tabActivity.setOnClickListener {
            selectTab(view.tabActivity)
        }

        view.tabFlights.setOnClickListener {
            selectTab(view.tabFlights)
        }

        view.tabHotels.setOnClickListener {
            selectTab(view.tabHotels)
        }

        return view
    }



    private fun selectTab(text : TextView){

        tabActivity.setTextColor(Color.parseColor("#53585A"));
        tabFlights.setTextColor(Color.parseColor("#53585A"));
        tabHotels.setTextColor(Color.parseColor("#53585A"));
        tabActivity.setBackgroundResource(0)
        tabFlights.setBackgroundResource(0)
        tabHotels.setBackgroundResource(0)

        text.setTextColor(Color.parseColor("#FFFFFF"));
        text.setBackgroundResource(com.tickitbookit.R.drawable.round_corner_blue_50)
    }

}

