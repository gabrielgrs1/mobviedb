package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.PopularMoviesRequestValues
import com.gabrielgrs.moviedb.presentation.mapper.popularmovies.PopularMoviesMapper
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovies
import io.reactivex.Observable
import org.koin.standalone.inject

open class PopularMoviesUseCase : BaseUseCase<PopularMoviesRequestValues, PopularMovies>() {

    private val moviesRepository: MoviesRepository by inject()

    override fun executeUseCase(requestValues: PopularMoviesRequestValues?): Observable<PopularMovies> {
        requestValues?.let {
            return@executeUseCase moviesRepository.getPopularMovies(requestValues.page)
                .map { response -> PopularMoviesMapper.transformTo(response) }
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}