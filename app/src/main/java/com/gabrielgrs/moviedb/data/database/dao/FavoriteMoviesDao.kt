package com.gabrielgrs.moviedb.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity
import io.reactivex.Observable

@Dao
interface FavoriteMoviesDao {

    @Query("SELECT * FROM favorite_movies WHERE id = :movieId")
    fun getFavoriteMovie(movieId: Int): Observable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavorites(movie: MovieEntity)

    @Delete
    fun removeFavorite(movie: MovieEntity)
}