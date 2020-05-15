package com.gabrielgrs.moviedb.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "spoken_languages")
data class SpokenLanguagesEntity(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "iso6931") val iso6931: String
) : Serializable