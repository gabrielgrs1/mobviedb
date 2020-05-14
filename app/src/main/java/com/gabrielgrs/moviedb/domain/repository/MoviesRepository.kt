package com.gabrielgrs.moviedb.domain.repository

import com.gabrielgrs.moviedb.domain.model.movie.PopularMoviesModel
import com.gabrielgrs.moviedb.domain.model.moviedetail.MovieDetailModel
import io.reactivex.Observable

interface MoviesRepository {
    fun getPopularMovies(page: Int): Observable<PopularMoviesModel>
    fun searchMovies(query: String, page: Int): Observable<PopularMoviesModel>
    fun getSimilarMovies(movieId: Int): Observable<PopularMoviesModel>
    fun getMovieDetails(movieId: Int): Observable<MovieDetailModel>
}