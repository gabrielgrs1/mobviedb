package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.PopularMoviesRequestValues
import com.gabrielgrs.moviedb.presentation.mapper.PopularMoviesMapper
import com.gabrielgrs.moviedb.presentation.model.movie.PopularMovies
import io.reactivex.Observable

open class PopularMoviesUseCase(private val moviesRepository: MoviesRepository) :
    BaseUseCase<PopularMoviesRequestValues, PopularMovies>() {

    override fun executeUseCase(requestValues: PopularMoviesRequestValues?): Observable<PopularMovies> {
        requestValues?.let {
            return@executeUseCase moviesRepository.getPopularMovies(requestValues.page)
                .map { response -> PopularMoviesMapper.transformTo(response) }
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}