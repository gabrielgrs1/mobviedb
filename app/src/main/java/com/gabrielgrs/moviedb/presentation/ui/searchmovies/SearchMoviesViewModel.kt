package com.gabrielgrs.moviedb.presentation.ui.searchmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gabrielgrs.moviedb.core.extensions.subscribeEither
import com.gabrielgrs.moviedb.core.plataform.BaseViewModel
import com.gabrielgrs.moviedb.core.plataform.Either
import com.gabrielgrs.moviedb.core.util.UseCaseHandler
import com.gabrielgrs.moviedb.domain.requestvalues.SearchMoviesRequestValues
import com.gabrielgrs.moviedb.domain.usecase.SearchMoviesUseCase
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovies
import org.koin.standalone.inject

class SearchMoviesViewModel : BaseViewModel() {

    private val searchMoviesUseCase: SearchMoviesUseCase by inject()
    val moviesListResponse: MutableLiveData<Either<Throwable, SearchMovies>> = MutableLiveData()

    fun searchMovies(query: String, page: Int) {
        Log.d(TAG, "Get movies like query $query at page $page")

        val searchMoviesRequestValues = SearchMoviesRequestValues(query, page)
        val useCase = UseCaseHandler.execute(searchMoviesUseCase, searchMoviesRequestValues)

        compositeDisposable.add(useCase.subscribeEither(moviesListResponse))
    }

    companion object {
        private const val TAG = "SEARCh_MOVIES_VM"
    }

}
