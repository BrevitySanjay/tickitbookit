package com.tickitbookit.classes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.tickitbookit.MyApp
import com.tickitbookit.R
import com.tickitbookit.databinding.CalenderBottomSheetBinding
import com.tickitbookit.utils.ConnectionLiveData
import com.tickitbookit.utils.InitApplication
import com.tickitbookit.utils.LoadingDialog

abstract class CustomFragment(context : Activity) : Fragment() {

    lateinit var loadingDialog: LoadingDialog
    var initApplication: InitApplication? = null
    var isInternetAvailable = false
    var firstTime = true
    var mContext = context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        ConnectionLiveData(mContext).observe(this, Observer<Boolean> { t ->
            MyApp.isInternetAvailable = t!!
            isInternetAvailable = t
            if (!firstTime) {
                val string = if (t) "Internet back" else "Internet Lost"
                Snackbar.make(mContext.window.decorView.rootView, string, Snackbar.LENGTH_LONG)
                        .setAction("CLOSE") { }
                        .setActionTextColor(resources.getColor(android.R.color.holo_red_light))
                        .show()
            }
            firstTime = false
        })
        loadingDialog = LoadingDialog(mContext)
    }

    override fun onResume() {
        super.onResume()
        firstTime = true
    }

  /*  override fun setContentView(layoutResID: Int) {
        initApplication = InitApplication(mContext)
        *//*if (initApplication!!.state) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }*//*
        super.setContentView(layoutResID)
        //setInitialLanguage()
    }*/

   /* abstract fun setInitialLanguage()*/

    /*abstract fun bindData()*/

    private fun showToast(message: String = "something went wrong") {
        mContext.runOnUiThread {
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
        }
    }

    fun startActivity(cls: Class<*>?) {
        val intent = Intent(mContext, cls)
        super.startActivity(intent)
    }

    private fun showLoadingDialog() {
        if (this::loadingDialog.isInitialized && !loadingDialog.isShowing()) {
            loadingDialog.show()
        }
    }

    fun changeLoadingStatus(show: Boolean) {
        if (show) showLoadingDialog()
        else hideLoadingDialog()
    }

    fun showLoadingDialog(title: String) {
        showLoadingDialog()
    }

    private fun hideLoadingDialog() {
        if (this::loadingDialog.isInitialized && loadingDialog.isShowing()) {
            loadingDialog.dismiss()
        }
    }

    fun showInternetErrorDialog() {
        showToast("Internet not available")
    }

    fun showAuthErrorDialog() {
        showToast("Auth Error")
    }



    fun calenderDialog() {

        val calenderSheet  = CalenderBottomSheetBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(mContext, R.style.SheetDialog)
        dialog.setCancelable(false)
        dialog.setContentView(calenderSheet.root)
        dialog.show()

        calenderSheet.imgClose.setOnClickListener { dialog.dismiss() }

    }


}