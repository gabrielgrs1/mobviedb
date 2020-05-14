package com.gabrielgrs.moviedb.presentation.ui

import androidx.fragment.app.Fragment
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.plataform.BaseActivity
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesFragment
import com.gabrielgrs.moviedb.presentation.ui.searchmovies.SearchMoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.mainBottomBarBnv

class MainActivity : BaseActivity() {
    override fun init() {
        setContentView(R.layout.activity_main)
        startFragment(PopularMoviesFragment.newInstance())
        mainBottomBarBnv.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_popular -> {
                    startFragment(PopularMoviesFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    startFragment(SearchMoviesFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun startFragment(fragment: Fragment) {
        var mFragment = fragment
        val findFragmentByTag =
            supportFragmentManager.findFragmentByTag(mFragment.javaClass.simpleName)

        if (findFragmentByTag != null && findFragmentByTag.isAdded) {
            mFragment = findFragmentByTag
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContentFl, mFragment, mFragment.javaClass.simpleName)
            .commit()
    }
}
