package com.gabrielgrs.moviedb.data.api.service

import com.gabrielgrs.moviedb.data.api.model.response.MovieDetailResponse
import com.gabrielgrs.moviedb.data.api.model.response.MovieResponse
import com.gabrielgrs.moviedb.data.api.model.response.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("/movie/popular")
    fun getPopularMovies(
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("/search/movie")
    fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("/movie/{movie_id}")
    fun getMovie(
        @Path("movie_id") movieId: Int
    ): Observable<MovieDetailResponse>

    @GET("/movie/{movie_id}/similar")
    fun getSimilarMovies(
        @Path("movie_id") movieId: Int
    ): Observable<MoviesResponse>

}