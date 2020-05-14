package com.gabrielgrs.moviedb.data.api.model.response.searchmovies

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchMovieResponse(
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("overview") val overview: String,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("genre_ids") val genreIdes: List<Int>,
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("title") val title: String,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("vote_count") var voteCount: Int,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double
) : Serializable