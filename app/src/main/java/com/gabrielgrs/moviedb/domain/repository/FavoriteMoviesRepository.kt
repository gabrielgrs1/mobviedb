package com.gabrielgrs.moviedb.domain.repository

interface FavoriteMoviesRepository {
    fun isMovieFavorite(movieId: Int): Boolean
    fun toggleMovieFavorite(movieId: Int)
}
