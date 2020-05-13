package com.gabrielgrs.moviedb.data.api.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList
import java.util.Date

data class MoviesResponse(
    @SerializedName("page") private var page: Int,
    @SerializedName("total_results") private val totalResults: Int,
    @SerializedName("total_pages") private val totalPages: Int,
    @SerializedName("results") private val results: ArrayList<MovieResponse>
) : Serializable

data class MovieResponse(
    @SerializedName("poster_path") private val posterPath: String?,
    @SerializedName("overview") private val overview: String,
    @SerializedName("adult") private val adult: Boolean,
    @SerializedName("release_date") private val releaseDate: Date,
    @SerializedName("genre_ids") private val genreIdes: List<Int>,
    @SerializedName("id") private val id: Int,
    @SerializedName("original_title") private val originalTitle: String,
    @SerializedName("original_language") private val originalLanguage: String,
    @SerializedName("title") private val title: String,
    @SerializedName("backdrop_path") private val backdropPath: String?,
    @SerializedName("popularity") private val popularity: Double,
    @SerializedName("vote_count") private var voteCount: Int,
    @SerializedName("video") private val video: Boolean,
    @SerializedName("vote_average") private val voteAverage: Double
) : Serializable