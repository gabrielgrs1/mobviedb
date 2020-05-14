package com.gabrielgrs.moviedb.core

import android.app.Application
import com.gabrielgrs.moviedb.core.di.fragmentModule
import com.gabrielgrs.moviedb.core.di.networkModule
import com.gabrielgrs.moviedb.core.di.repositoryModule
import com.gabrielgrs.moviedb.core.di.useCaseModule
import com.gabrielgrs.moviedb.core.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MovieDbApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                networkModule,
                viewModelModule,
                fragmentModule,
                repositoryModule,
                useCaseModule
            )
        )
    }
}