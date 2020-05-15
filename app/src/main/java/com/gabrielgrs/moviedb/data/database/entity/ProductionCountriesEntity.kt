package com.gabrielgrs.moviedb.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "production_countries")
data class ProductionCountriesEntity(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "iso31661") val iso31661: String
) : Serializable