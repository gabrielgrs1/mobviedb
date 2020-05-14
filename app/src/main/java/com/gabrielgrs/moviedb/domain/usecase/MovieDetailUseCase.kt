package com.gabrielgrs.moviedb.domain.usecase

import com.gabrielgrs.moviedb.core.plataform.BaseUseCase
import com.gabrielgrs.moviedb.domain.exception.RequestValuesNotImplementedException
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.requestvalues.MovieDetailRequestValues
import com.gabrielgrs.moviedb.presentation.mapper.moviedetail.MovieDetailMapper
import com.gabrielgrs.moviedb.presentation.model.moviedetail.MovieDetail
import io.reactivex.Observable
import org.koin.standalone.inject

open class MovieDetailUseCase : BaseUseCase<MovieDetailRequestValues, MovieDetail>() {

    private val moviesRepository: MoviesRepository by inject()

    override fun executeUseCase(requestValues: MovieDetailRequestValues?): Observable<MovieDetail> {
        requestValues?.let {
            return@executeUseCase moviesRepository.getMovieDetails(requestValues.movieId)
                .map { response -> MovieDetailMapper.transformTo(response) }
        }
        return Observable.error(RequestValuesNotImplementedException())
    }
}