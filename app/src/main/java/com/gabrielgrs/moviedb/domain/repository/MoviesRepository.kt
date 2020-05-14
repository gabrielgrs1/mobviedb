package com.gabrielgrs.moviedb.domain.repository

import com.gabrielgrs.moviedb.domain.model.movie.PopularMoviesModel
import com.gabrielgrs.moviedb.domain.model.moviedetail.MovieDetailModel
import com.gabrielgrs.moviedb.domain.model.searchmovies.SearchMoviesModel
import com.gabrielgrs.moviedb.domain.model.similarmovie.SimilarMoviesModel
import io.reactivex.Observable

interface MoviesRepository {
    fun getPopularMovies(page: Int): Observable<PopularMoviesModel>
    fun searchMovies(query: String, page: Int): Observable<SearchMoviesModel>
    fun getSimilarMovies(movieId: Int): Observable<SimilarMoviesModel>
    fun getMovieDetails(movieId: Int): Observable<MovieDetailModel>
}