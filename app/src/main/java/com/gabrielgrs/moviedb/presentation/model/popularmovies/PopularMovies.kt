package com.gabrielgrs.moviedb.presentation.model.popularmovies

class PopularMovies(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<PopularMovie>
)