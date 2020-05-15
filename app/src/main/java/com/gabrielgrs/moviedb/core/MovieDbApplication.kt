package com.gabrielgrs.moviedb.core

import android.app.Application
import com.gabrielgrs.moviedb.core.di.daoModule
import com.gabrielgrs.moviedb.core.di.persistenceModule
import com.gabrielgrs.moviedb.core.di.repositoryModule
import com.gabrielgrs.moviedb.core.di.useCaseModule
import com.gabrielgrs.moviedb.core.di.viewModelModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.KoinComponent

class MovieDbApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                persistenceModule,
                viewModelModule,
                repositoryModule,
                useCaseModule,
                daoModule
            )
        )
    }
}