package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.SimilarMoviesRequestValues
import com.gabrielgrs.moviedb.presentation.mapper.similarmovie.SimilarMoviesMapper
import com.gabrielgrs.moviedb.presentation.model.similarmovies.SimilarMovies
import io.reactivex.Observable
import org.koin.standalone.inject

open class SimilarMoviesUseCase : BaseUseCase<SimilarMoviesRequestValues, SimilarMovies>() {

    private val moviesRepository: MoviesRepository by inject()

    override fun executeUseCase(requestValues: SimilarMoviesRequestValues?): Observable<SimilarMovies> {
        requestValues?.let {
            return@executeUseCase moviesRepository.getSimilarMovies(requestValues.movieId)
                .map { response -> SimilarMoviesMapper.transformTo(response) }
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}