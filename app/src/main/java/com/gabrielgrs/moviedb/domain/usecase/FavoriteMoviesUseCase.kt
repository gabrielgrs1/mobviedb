package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.FavoriteMoviesRequestValues
import io.reactivex.Observable
import org.koin.standalone.inject

open class FavoriteMoviesUseCase : BaseUseCase<FavoriteMoviesRequestValues, Boolean>() {

    private val favoriteMoviesRepository: FavoriteMoviesRepository by inject()

    override fun executeUseCase(requestValues: FavoriteMoviesRequestValues?): Observable<Boolean> {
        requestValues?.let {
            return@executeUseCase favoriteMoviesRepository.toggleMovieFavorite(
                requestValues.movieId,
                requestValues.isFavorite
            )
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}