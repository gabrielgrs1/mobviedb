package com.gabrielgrs.moviedb.presentation.model.searchmovies

class SearchMovies(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<SearchMovie>
)