package com.tickitbookit.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tickitbookit.adapter.GalleryAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityDetailsBinding
import com.tickitbookit.databinding.ActivityGalleryBinding
import com.tickitbookit.moels.DummyData

class ActivityDetailsActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewClick()

    }
    private fun viewClick(){

        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.viewGalleryImages.setOnClickListener {
            startActivity(Intent(this,GalleryActivity::class.java))
        }
    }
}