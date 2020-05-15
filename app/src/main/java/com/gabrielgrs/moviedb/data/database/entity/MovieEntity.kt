package com.gabrielgrs.moviedb.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.Date

@Entity(tableName = "favorite_movies")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "budget") val budget: Int,
    @ColumnInfo(name = "homepage") val homepage: String?,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    @ColumnInfo(name = "overview") val overview: String?,
    @ColumnInfo(name = "release_date") val releaseDate: Date,
    @ColumnInfo(name = "genre") val genre: List<GenreEntity>?,
    @ColumnInfo(name = "imdb_id") val imdbId: String?,
    @ColumnInfo(name = "original_title") val originalTitle: String,
    @ColumnInfo(name = "original_language") val originalLanguage: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "tagline") val tagline: String?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "backdrop_Path") val backdropPath: String?,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "revenue") val revenue: Int,
    @ColumnInfo(name = "runtime") val runtime: Int?,
    @ColumnInfo(name = "voteCount") var voteCount: Int,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "production_companies") val productionCompanies: List<ProductionCompaniesEntity>,
    @ColumnInfo(name = "production_countries") val productionCountries: List<ProductionCountriesEntity>,
    @ColumnInfo(name = "spoken_languages") val spokenLanguages: List<SpokenLanguagesEntity>,
    @ColumnInfo(name = "vote_average") val voteAverage: Double
) : Serializable {

}