package com.gabrielgrs.moviedb.data.api.repository

import com.gabrielgrs.moviedb.core.api.ErrorResponseHandler.handleApiCallErrors
import com.gabrielgrs.moviedb.data.api.service.IApiService
import com.gabrielgrs.moviedb.data.mapper.moviedetail.MovieDetailMapper
import com.gabrielgrs.moviedb.data.mapper.popularmovies.PopularMoviesMapper
import com.gabrielgrs.moviedb.data.mapper.searchmovies.SearchMoviesMapper
import com.gabrielgrs.moviedb.data.mapper.similarmovie.SimilarMoviesMapper
import com.gabrielgrs.moviedb.domain.model.movie.PopularMoviesModel
import com.gabrielgrs.moviedb.domain.model.moviedetail.MovieDetailModel
import com.gabrielgrs.moviedb.domain.model.searchmovies.SearchMoviesModel
import com.gabrielgrs.moviedb.domain.model.similarmovie.SimilarMoviesModel
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

    override fun searchMovies(query: String, page: Int): Observable<SearchMoviesModel> =
        iApiService.searchMovies(query, page)
            .map { response -> SearchMoviesMapper.transformTo(response) }
            .onErrorResumeNext(handleApiCallErrors())

    override fun getSimilarMovies(movieId: Int): Observable<SimilarMoviesModel> =
        iApiService.getSimilarMovies(movieId)
            .map { response -> SimilarMoviesMapper.transformTo(response) }
            .onErrorResumeNext(handleApiCallErrors())

    override fun getMovieDetails(movieId: Int): Observable<MovieDetailModel> =
        iApiService.getMovieDetails(movieId)
            .map { response -> MovieDetailMapper.transformTo(response) }
            .onErrorResumeNext(handleApiCallErrors())
}