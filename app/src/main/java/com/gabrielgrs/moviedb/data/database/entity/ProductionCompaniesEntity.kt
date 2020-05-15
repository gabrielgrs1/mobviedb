package com.gabrielgrs.moviedb.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "production_companies")
data class ProductionCompaniesEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "logo_path")  val logoPath: String?,
    @ColumnInfo(name = "original_country")  val originalCountry: String
) : Serializable