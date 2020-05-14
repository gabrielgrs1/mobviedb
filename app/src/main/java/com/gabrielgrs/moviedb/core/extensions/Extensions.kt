package com.gabrielgrs.moviedb.core.extensions

import androidx.lifecycle.MutableLiveData
import com.gabrielgrs.moviedb.core.plataform.Either
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.subscribeEither(liveData: MutableLiveData<Either<Throwable, T>>): Disposable {
    return this.subscribe({
        liveData.value = Either.Right(it)
    }, {
        liveData.value = Either.Left(it)
    })
}

