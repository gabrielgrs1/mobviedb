package com.gabrielgrs.moviedb.presentation.ui

import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.plataform.BaseActivity
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesFragment

class MainActivity : BaseActivity() {
    override fun init() {
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.mainContent, PopularMoviesFragment.newInstance()).commit()
    }
}
