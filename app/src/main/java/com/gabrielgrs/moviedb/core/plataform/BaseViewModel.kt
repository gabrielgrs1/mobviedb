package com.gabrielgrs.moviedb.core.plataform

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
