package com.gabrielgrs.moviedb.data.api.model.response.similarmovies

import com.google.gson.annotations.SerializedName

data class SimilarMovieResponse(
    @SerializedName("title") val title: String = "",
    @SerializedName("poster_path") val posterPath: String? = ""
)