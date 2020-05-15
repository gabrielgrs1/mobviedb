package com.gabrielgrs.moviedb.domain.repository

import com.gabrielgrs.moviedb.data.database.entity.MovieEntity
import io.reactivex.Observable

interface FavoriteMoviesRepository {
    fun isMovieFavorite(movieId: Int): Observable<List<MovieEntity>>
    fun toggleMovieFavorite(movieId: Int, favorite: Boolean): Observable<Boolean>
}
