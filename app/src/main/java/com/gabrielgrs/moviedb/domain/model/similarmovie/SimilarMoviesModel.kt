package com.gabrielgrs.moviedb.domain.model.similarmovie

import java.io.Serializable

data class SimilarMoviesModel(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<SimilarMovieModel>
) : Serializable
