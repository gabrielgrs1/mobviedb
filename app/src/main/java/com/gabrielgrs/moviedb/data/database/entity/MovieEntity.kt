package com.gabrielgrs.moviedb.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite_movies")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int
) : Serializable