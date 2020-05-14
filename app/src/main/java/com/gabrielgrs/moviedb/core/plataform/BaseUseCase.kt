package com.gabrielgrs.moviedb.core.plataform

import io.reactivex.Observable

abstract class BaseUseCase<in RV : BaseRequestValues, T> {
    private var requestValue: RV? = null

    fun setRequestValues(requestValues: RV?) {
        this.requestValue = requestValues
    }

    fun run(): Observable<T> {
        return executeUseCase(requestValue)
    }

    abstract fun executeUseCase(requestValues: RV? = null): Observable<T>
}
