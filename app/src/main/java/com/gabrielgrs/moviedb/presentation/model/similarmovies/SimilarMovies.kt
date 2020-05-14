package com.gabrielgrs.moviedb.presentation.model.similarmovies

data class SimilarMovies(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<SimilarMovie>
)