package com.gabrielgrs.moviedb.data.api.model.response.similarmovies

import com.google.gson.annotations.SerializedName

data class SimilarMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<SimilarMovieResponse>
)