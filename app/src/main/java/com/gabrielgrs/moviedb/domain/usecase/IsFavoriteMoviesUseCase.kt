package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.IsFavoriteMoviesRequestValues
import io.reactivex.Observable
import org.koin.standalone.inject

open class IsFavoriteMoviesUseCase :
    BaseUseCase<IsFavoriteMoviesRequestValues, List<MovieEntity>>() {

    private val favoriteMoviesRepository: FavoriteMoviesRepository by inject()

    override fun executeUseCase(requestValues: IsFavoriteMoviesRequestValues?): Observable<List<MovieEntity>> {
        requestValues?.let {
            return@executeUseCase favoriteMoviesRepository.isMovieFavorite(requestValues.movieId)
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}