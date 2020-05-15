package com.gabrielgrs.moviedb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabrielgrs.moviedb.data.database.dao.FavoriteMoviesDao
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity

@Database(entities = arrayOf(MovieEntity::class), version = 1, exportSchema = false)
abstract class MovieDbRoomDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

}