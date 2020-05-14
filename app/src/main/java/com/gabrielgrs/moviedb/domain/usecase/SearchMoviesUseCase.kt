package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.SearchMoviesRequestValues
import com.gabrielgrs.moviedb.presentation.mapper.searchmovies.SearchMoviesMapper
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovies
import io.reactivex.Observable
import org.koin.standalone.inject

open class SearchMoviesUseCase : BaseUseCase<SearchMoviesRequestValues, SearchMovies>() {

    private val moviesRepository: MoviesRepository by inject()

    override fun executeUseCase(requestValues: SearchMoviesRequestValues?): Observable<SearchMovies> {
        requestValues?.let {
            return@executeUseCase moviesRepository.searchMovies(
                requestValues.query,
                requestValues.page
            )
                .map { response -> SearchMoviesMapper.transformTo(response) }
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}