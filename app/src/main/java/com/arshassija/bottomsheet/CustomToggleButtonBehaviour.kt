package com.arshassija.bottomsheet

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout

class CustomToggleButtonBehaviour : CoordinatorLayout.Behavior<MyButton>() {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: MyButton,
        dependency: View
    ): Boolean {
        return dependency is TextView
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: MyButton,
        dependency: View
    ): Boolean {
        Log.e("changed", "changed")
        return super.onDependentViewChanged(parent, child, dependency)
    }

}