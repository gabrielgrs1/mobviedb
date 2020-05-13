package com.gabrielgrs.moviedb.data.api.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

data class MovieDetailResponse(
    @SerializedName("adult") private val adult: Boolean,
    @SerializedName("belongs_to_collection") private val belongsToCollection: Any?,
    @SerializedName("budget") private val budget: Int,
    @SerializedName("homepage") private val homepage: String?,
    @SerializedName("poster_path") private val posterPath: String?,
    @SerializedName("overview") private val overview: String?,
    @SerializedName("release_date") private val releaseDate: Date,
    @SerializedName("genre") private val genre: List<Genre>,
    @SerializedName("id") private val id: Int,
    @SerializedName("imdb_id") private val imdbId: Int?,
    @SerializedName("original_title") private val originalTitle: String,
    @SerializedName("original_language") private val originalLanguage: String,
    @SerializedName("status") private val status: String,
    @SerializedName("tagline") private val tagline: String?,
    @SerializedName("title") private val title: String,
    @SerializedName("backdrop_path") private val backdropPath: String?,
    @SerializedName("popularity") private val popularity: Double,
    @SerializedName("revenue") private val revenue: Int,
    @SerializedName("runtime") private val runtime: Int?,
    @SerializedName("vote_count") private var voteCount: Int,
    @SerializedName("video") private val video: Boolean,
    @SerializedName("production_companies") private val productionCompanies: List<ProductionCompanies>,
    @SerializedName("production_countries") private val productionCountries: List<ProductionCountries>,
    @SerializedName("spoken_languages") private val spokenLanguages: List<SpokenLanguages>,
    @SerializedName("vote_average") private val voteAverage: Double
)

data class Genre(
    @SerializedName("id") private val id: Int,
    @SerializedName("name") private val name: String
) : Serializable

data class ProductionCompanies(
    @SerializedName("id") private val id: Int,
    @SerializedName("name") private val name: String,
    @SerializedName("logo_path") private val logoPath: String?,
    @SerializedName("original_country") private val originalCountry: String
) : Serializable

data class ProductionCountries(
    @SerializedName("name") private val name: String,
    @SerializedName("iso_3166_1") private val iso31661: String
) : Serializable

data class SpokenLanguages(
    @SerializedName("name") private val name: String,
    @SerializedName("iso_639_1") private val iso6931: String
) : Serializable
