package com.tickitbookit.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tickitbookit.R
import com.tickitbookit.adapter.CategoryAdapter
import com.tickitbookit.adapter.CategoryAdapter1
import com.tickitbookit.adapter.SearchItemAdapter
import com.tickitbookit.databinding.FilterBottomSheetBinding
import com.tickitbookit.databinding.FragmentHomeBinding
import com.tickitbookit.moels.DummyData
import com.xiaofeng.flowlayoutmanager.Alignment
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private val result = java.util.ArrayList<String>()

    private val searchItems = ArrayList<DummyData>()
    private val categoryItem = ArrayList<DummyData>()
    private val categoryItem1 = ArrayList<DummyData>()

    private lateinit var category1Manager: FlowLayoutManager
    lateinit var categoryManager: FlowLayoutManager

    var itemDecoration: ItemDecoration = object : ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect[5, 5, 5] = 5
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        searchItems.add(DummyData("350", "350"))
        searchItems.add(DummyData("350", "550"))
        searchItems.add(DummyData("350", "632"))
        searchItems.add(DummyData("350", "77"))
        searchItems.add(DummyData("350", "20"))
        searchItems.add(DummyData("350", "1050"))

        categoryItem.add(DummyData("350", "All"))
        categoryItem.add(DummyData("350", "Air Activities"))
        categoryItem.add(DummyData("350", "Active & Fun"))

        categoryItem1.add(DummyData("350", "Air, Helicopter & Balloon Tours"))
        categoryItem1.add(DummyData("350", "Space Travel"))
        categoryItem1.add(DummyData("350", "Para Gliding"))
        categoryItem1.add(DummyData("350", "Indoor"))
        categoryItem1.add(DummyData("350", "Outdoor"))
        categoryItem1.add(DummyData("350", "Rides"))

        binding.rvSearchActivity.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvSearchActivity.adapter = SearchItemAdapter(searchItems)
        binding.tvActivityDetail1.text = searchItems.size.toString()

        viewClick()

        return binding.root
    }


    private fun viewClick(){
        binding.filter.setOnClickListener {
            filterDialog()
        }
    }

    private fun filterDialog() {

        val filterBottomSheet = FilterBottomSheetBinding.inflate(layoutInflater)
        val dialog = context?.let { it1 -> BottomSheetDialog(it1, R.style.SheetDialog) }
        dialog?.setCancelable(false)
        dialog?.setContentView(filterBottomSheet.root)
        dialog?.show()

        categoryManager = FlowLayoutManager().setAlignment(Alignment.LEFT)
        categoryManager.isAutoMeasureEnabled = true
        filterBottomSheet.rvCategory.layoutManager = categoryManager
        filterBottomSheet.rvCategory.adapter = CategoryAdapter(categoryItem)
        filterBottomSheet.rvCategory.addItemDecoration(itemDecoration)

        category1Manager = FlowLayoutManager().setAlignment(Alignment.LEFT)
        category1Manager.isAutoMeasureEnabled = true
        filterBottomSheet.rvCategory1.layoutManager = category1Manager
        filterBottomSheet.rvCategory1.adapter = CategoryAdapter1(categoryItem1)
        filterBottomSheet.rvCategory1.addItemDecoration(itemDecoration)

        filterBottomSheet.imgClose.setOnClickListener {
            dialog?.dismiss()
        }
    }
}