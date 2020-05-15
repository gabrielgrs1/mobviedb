package com.gabrielgrs.moviedb.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "genre")
data class GenreEntity(
    @PrimaryKey
    val id: Int,
    val name: String
) : Serializable