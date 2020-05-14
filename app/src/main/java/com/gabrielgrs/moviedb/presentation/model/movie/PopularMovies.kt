package com.gabrielgrs.moviedb.presentation.model.movie

class PopularMovies(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<PopularMovie>
)