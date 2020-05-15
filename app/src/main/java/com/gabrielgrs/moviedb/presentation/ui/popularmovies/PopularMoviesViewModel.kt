package com.gabrielgrs.moviedb.presentation.ui.popularmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gabrielgrs.moviedb.core.extensions.subscribeEither
import com.gabrielgrs.moviedb.core.plataform.BaseViewModel
import com.gabrielgrs.moviedb.core.plataform.Either
import com.gabrielgrs.moviedb.core.util.UseCaseHandler
import com.gabrielgrs.moviedb.domain.requestvalues.PopularMoviesRequestValues
import com.gabrielgrs.moviedb.domain.usecase.PopularMoviesUseCase
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovies
import org.koin.standalone.inject

class PopularMoviesViewModel : BaseViewModel() {

    private val popularMoviesUseCase: PopularMoviesUseCase by inject()
    val moviesListResponse: MutableLiveData<Either<Throwable, PopularMovies>> = MutableLiveData()

    fun getPopularMovies(page: Int) {
        Log.d(TAG, "Get page $page at popular movies")

        val popularMoviesRequestValues = PopularMoviesRequestValues(page)
        val useCase = UseCaseHandler.execute(popularMoviesUseCase, popularMoviesRequestValues)

        compositeDisposable.add(useCase.subscribeEither(moviesListResponse))
    }

    companion object {
        private const val TAG = "POPULAR_MOVIES_VM"
    }
}
