package com.gabrielgrs.moviedb.data.api.model.response.moviedetail

import com.google.gson.annotations.SerializedName
import java.util.Date

data class MovieDetailResponse(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("budget") val budget: Int,
    @SerializedName("homepage") val homepage: String? = "",
    @SerializedName("poster_path") val posterPath: String? = "",
    @SerializedName("overview") val overview: String? = "",
    @SerializedName("release_date") val releaseDate: Date,
    @SerializedName("genre") val genreResponse: List<GenreResponse>? = listOf(),
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdbId: String? = "",
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String? = "",
    @SerializedName("title") val title: String,
    @SerializedName("backdrop_path") val backdropPath: String? = "",
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int? = 0,
    @SerializedName("vote_count") var voteCount: Int,
    @SerializedName("video") val video: Boolean,
    @SerializedName("production_companies") val productionCompanyResponses: List<ProductionCompaniesResponse>,
    @SerializedName("production_countries") val productionCountryResponses: List<ProductionCountriesResponse>,
    @SerializedName("spoken_languages") val spokenLanguageResponses: List<SpokenLanguagesResponse>,
    @SerializedName("vote_average") val voteAverage: Double
)

