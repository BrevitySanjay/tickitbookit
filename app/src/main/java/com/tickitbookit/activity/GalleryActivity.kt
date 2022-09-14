package com.tickitbookit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.adapter.GalleryAdapter
import com.tickitbookit.adapter.SearchItemAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.moels.DummyData
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class GalleryActivity : CustomAppCompatActivity() {

    private val searchItems = ArrayList<DummyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))

        rvGallery.layoutManager = GridLayoutManager(this, 2)
        rvGallery.adapter = GalleryAdapter(searchItems)

        imgBack.setOnClickListener {
            finish()
        }

    }
}