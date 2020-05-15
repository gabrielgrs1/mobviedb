package com.gabrielgrs.moviedb.data.api.model.response.searchmovies

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<SearchMovieResponse>
) : Serializable
