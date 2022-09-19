package com.tickitbookit.activity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tickitbookit.adapter.GalleryAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityGalleryBinding
import com.tickitbookit.moels.DummyData

class GalleryActivity : CustomAppCompatActivity() {

    private val searchItems = ArrayList<DummyData>()
    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))
        searchItems.add(DummyData("350","Lorem Ipsum is simply dummy text of the printing Lorem Ipsum is simply dummy text of the printing"))

        binding.rvGallery.layoutManager = GridLayoutManager(this, 2)
        binding.rvGallery.adapter = GalleryAdapter(searchItems)
        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}