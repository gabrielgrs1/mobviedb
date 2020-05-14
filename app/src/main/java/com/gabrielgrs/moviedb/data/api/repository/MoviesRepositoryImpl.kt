package com.gabrielgrs.moviedb.data.api.repository

import com.gabrielgrs.moviedb.core.api.ErrorResponseHandler.handleApiCallErrors
import com.gabrielgrs.moviedb.data.api.service.IApiService
import com.gabrielgrs.moviedb.data.mapper.PopularMoviesMapper
import com.gabrielgrs.moviedb.domain.model.movie.PopularMoviesModel
import com.gabrielgrs.moviedb.domain.model.moviedetail.MovieDetailModel
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MoviesRepositoryImpl : MoviesRepository, KoinComponent {
    private val iApiService: IApiService by inject()

    override fun getPopularMovies(page: Int): Observable<PopularMoviesModel> =
        iApiService.getPopularMovies(page)
            .map { response -> PopularMoviesMapper.transformTo(response) }
            .onErrorResumeNext(handleApiCallErrors())

    override fun searchMovies(query: String, page: Int): Observable<PopularMoviesModel> {
        TODO("Not yet implemented")
    }

    override fun getSimilarMovies(movieId: Int): Observable<PopularMoviesModel> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetails(movieId: Int): Observable<MovieDetailModel> {
        TODO("Not yet implemented")
    }
}