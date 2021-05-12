package com.arshassija.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton
    private lateinit var byeWorldTV: TextView
    private lateinit var mSheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        byeWorldTV = findViewById(R.id.text)
        val sheetView = findViewById<View>(R.id.bottom_sheet)

        mSheetBehavior = BottomSheetBehavior.from(sheetView)
        mSheetBehavior.setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
            override fun onSlide(view: View, v: Float) { //-1 -> 0 -> +1
                Log.e("onSlide", v.toString())
                val position = resources.displayMetrics.heightPixels / 2 * (1 - v)
                Log.e("onSlide", position.toString())
                byeWorldTV.y = position
                byeWorldTV.textSize = 24F * (1 - v)
            }
        })
//        mSheetBehavior.isFitToContents = true
    }

    fun open(view: View) {
        mSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        mSheetBehavior.skipCollapsed = true
    }

}