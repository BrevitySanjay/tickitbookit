package com.tickitbookit.controls

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat


class CButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr) {

    init {
        elevation = 5f
        textSize = 16f
        setTextColor(ColorStateList.valueOf(Color.parseColor("#ffffff")))

        height = (50 * Resources.getSystem().displayMetrics.density).toInt()
        width = (250 * Resources.getSystem().displayMetrics.density).toInt()

        setTypeface(null, Typeface.BOLD)
        gravity = Gravity.CENTER
        //background = ContextCompat.getDrawable(context, R.drawable.default_button_background)
         //backgroundTintList= ColorStateList.valueOf(themeColor(R.attr.colorOnSecondary))

        setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event!!.action) {
                    MotionEvent.ACTION_DOWN -> {
//                         backgroundTintList= ColorStateList.valueOf(themeColor(R.attr.colorSecondaryVariant))
                        elevation = 15f
                        return false
                    }
                    MotionEvent.ACTION_UP -> {
                        elevation = 3f
                        // backgroundTintList= ColorStateList.valueOf(themeColor(R.attr.colorOnSecondary))
                        return false
                    }
                }
                return false
            }
        })

    }

    fun themeColor(@AttrRes attrRes: Int): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(attrRes, typedValue, true)
        return typedValue.data
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}