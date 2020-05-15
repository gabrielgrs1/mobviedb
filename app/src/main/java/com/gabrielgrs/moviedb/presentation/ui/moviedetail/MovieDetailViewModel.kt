package com.gabrielgrs.moviedb.presentation.ui.moviedetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gabrielgrs.moviedb.core.extensions.subscribeEither
import com.gabrielgrs.moviedb.core.plataform.BaseViewModel
import com.gabrielgrs.moviedb.core.plataform.Either
import com.gabrielgrs.moviedb.core.util.UseCaseHandler
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.MovieDetailRequestValues
import com.gabrielgrs.moviedb.domain.requestvalues.SimilarMoviesRequestValues
import com.gabrielgrs.moviedb.domain.usecase.MovieDetailUseCase
import com.gabrielgrs.moviedb.domain.usecase.SimilarMoviesUseCase
import com.gabrielgrs.moviedb.presentation.model.moviedetail.MovieDetail
import com.gabrielgrs.moviedb.presentation.model.similarmovies.SimilarMovies
import org.koin.standalone.inject

class MovieDetailViewModel : BaseViewModel() {

    private val movieDetailUseCase: MovieDetailUseCase by inject()
    private val similarMoviesUseCase: SimilarMoviesUseCase by inject()
    private val favoriteMoviesRepository: FavoriteMoviesRepository by inject()

    val movieDetailResponse: MutableLiveData<Either<Throwable, MovieDetail>> = MutableLiveData()
    val isFavoriteMovieResponse: MutableLiveData<Boolean> = MutableLiveData()
    val similarMoviesResponse: MutableLiveData<Either<Throwable, SimilarMovies>> = MutableLiveData()

    fun getMovieDetail(movieId: Int) {
        Log.d(TAG, "Get move details at id $movieId")

        val movieDetailRequestValues = MovieDetailRequestValues(movieId)
        val useCase = UseCaseHandler.execute(movieDetailUseCase, movieDetailRequestValues)

        compositeDisposable.add(useCase.subscribeEither(movieDetailResponse))
    }

    fun getSimilarMovies(movieId: Int) {
        Log.d(TAG, "Get similar movies at id $movieId")

        val similarMoviesRequestValues = SimilarMoviesRequestValues(movieId)
        val useCase = UseCaseHandler.execute(similarMoviesUseCase, similarMoviesRequestValues)

        compositeDisposable.add(useCase.subscribeEither(similarMoviesResponse))
    }

    fun isMovieFavorite(movieId: Int) {
        Log.d(TAG, "Verify movie at id $movieId is favorite")

        favoriteMoviesRepository.isMovieFavorite(movieId)

    }

    companion object {
        private const val TAG = "MOVIE_DETAIL_VM"
    }

}
