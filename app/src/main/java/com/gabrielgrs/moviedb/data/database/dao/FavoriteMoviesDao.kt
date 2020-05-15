package com.gabrielgrs.moviedb.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity

@Dao
interface FavoriteMoviesDao {

    @Query("SELECT * from favorite_movies WHERE id = :movieId")
    fun getFavoriteMovie(movieId: Int): MovieEntity

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addToFavorites(movie: MovieEntity)

    @Delete
    fun removeFavorite(movie: MovieEntity)
}