package com.gabrielgrs.moviedb.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gabrielgrs.moviedb.data.database.dao.FavoriteMoviesDao
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity

@Database(entities = arrayOf(MovieEntity::class), version = 1, exportSchema = false)
abstract class MovieDbRoomDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDbRoomDatabase? = null

        fun getDatabase(context: Context): MovieDbRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDbRoomDatabase::class.java,
                    "favorite_movies_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}