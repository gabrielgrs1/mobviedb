package com.gabrielgrs.moviedb.domain.repository

import com.gabrielgrs.moviedb.data.database.entity.MovieEntity

interface FavoriteMoviesRepository {
    fun isMovieFavorite(movieId: Int): Boolean
    fun addToFavorites(movie: MovieEntity)
    fun removeFavorite(movie: MovieEntity)
}
