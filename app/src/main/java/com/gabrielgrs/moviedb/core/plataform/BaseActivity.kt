package com.gabrielgrs.moviedb.core.plataform

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        init()
    }

    fun addFragment(resId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
    }

    protected fun replaceFragment(fragment: Fragment, layoutId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(layoutId, fragment)
            .addToBackStack(fragment.javaClass.name).commit()
    }


}