package com.tickitbookit.fragment

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.adapter.SearchItemAdapter
import com.tickitbookit.moels.DummyData
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private val searchItems = ArrayList<DummyData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        searchItems.add(DummyData("350","350"))
        searchItems.add(DummyData("350","550"))
        searchItems.add(DummyData("350","632"))
        searchItems.add(DummyData("350","77"))
        searchItems.add(DummyData("350","20"))
        searchItems.add(DummyData("350","1050"))

        view.rvSearchActivity.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        view.rvSearchActivity.adapter = SearchItemAdapter(searchItems)
        view.tvActivityDetail1.text = searchItems.size.toString()

        return view
    }

}