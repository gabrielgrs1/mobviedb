package com.gabrielgrs.moviedb.data.database.repository

import com.gabrielgrs.moviedb.data.database.dao.FavoriteMoviesDao
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository

class FavoriteMoviesRepositoryImpl(private val favoriteMoviesDao: FavoriteMoviesDao)  :
    FavoriteMoviesRepository {
    override fun isMovieFavorite(movieId: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun addToFavorites(movie: MovieEntity) {
        TODO("Not yet implemented")
    }

    override fun removeFavorite(movie: MovieEntity) {
        TODO("Not yet implemented")
    }
}