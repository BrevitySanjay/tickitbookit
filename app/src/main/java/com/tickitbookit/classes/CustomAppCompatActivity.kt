package com.tickitbookit.classes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.tickitbookit.MyApp
import com.tickitbookit.utils.ConnectionLiveData
import com.tickitbookit.utils.InitApplication
import com.tickitbookit.utils.LoadingDialog

abstract class CustomAppCompatActivity : AppCompatActivity() {

    lateinit var loadingDialog: LoadingDialog
    var initApplication: InitApplication? = null
    var isInternetAvailable = false
    var firstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        ConnectionLiveData(this).observe(this, Observer<Boolean> { t ->
            MyApp.isInternetAvailable = t!!
            isInternetAvailable = t
            if (!firstTime) {
                val string = if (t) "Internet back" else "Internet Lost"
                Snackbar.make(window.decorView.rootView, string, Snackbar.LENGTH_LONG)
                        .setAction("CLOSE") { }
                        .setActionTextColor(resources.getColor(android.R.color.holo_red_light))
                        .show()
            }
            firstTime = false
        })
        loadingDialog = LoadingDialog(this)
    }

    override fun onResume() {
        super.onResume()
        firstTime = true
    }

    override fun setContentView(layoutResID: Int) {
        initApplication = InitApplication(this)
        /*if (initApplication!!.state) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }*/
        super.setContentView(layoutResID)
        //setInitialLanguage()
    }

   /* abstract fun setInitialLanguage()*/

    /*abstract fun bindData()*/

    private fun showToast(message: String = "something went wrong") {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

    fun startActivity(cls: Class<*>?) {
        val intent = Intent(this, cls)
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


}