package com.gabrielgrs.moviedb.data.api.service

import com.gabrielgrs.moviedb.data.api.model.response.movie.MoviesResponse
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.MovieDetailResponse
import com.gabrielgrs.moviedb.data.api.model.response.searchmovies.SearchMoviesResponse
import com.gabrielgrs.moviedb.data.api.model.response.similarmovies.SimilarMoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("page") page: Int
    ): Observable<MoviesResponse>

    @GET("search/movie")
    fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Observable<SearchMoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): Observable<MovieDetailResponse>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(
        @Path("movie_id") movieId: Int
    ): Observable<SimilarMoviesResponse>
}