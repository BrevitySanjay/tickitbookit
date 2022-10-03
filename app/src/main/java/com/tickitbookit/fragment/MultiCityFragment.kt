package com.tickitbookit.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.adapter.MultiCountryAdapter
import com.tickitbookit.adapter.SearchItemAdapter
import com.tickitbookit.classes.CustomFragment
import com.tickitbookit.databinding.FragmentMultiCityBinding
import com.tickitbookit.moels.DummyData


class MultiCityFragment(context : Activity) : CustomFragment(context) {

    private lateinit var binding : FragmentMultiCityBinding
    private val searchItems = ArrayList<DummyData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMultiCityBinding.inflate(inflater)

        searchItems.add(DummyData("350", "350"))
        searchItems.add(DummyData("350", "550"))
        searchItems.add(DummyData("350", "632"))

        val adapter = MultiCountryAdapter(searchItems)
        binding.rvTripCountry.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvTripCountry.adapter = adapter

        adapter.setOnItemClickListener(object : MultiCountryAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                adapter.notifyItemRemoved(position)
                searchItems.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        })

        return binding.root
    }

}