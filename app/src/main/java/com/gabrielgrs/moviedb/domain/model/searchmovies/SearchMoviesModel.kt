package com.gabrielgrs.moviedb.domain.model.searchmovies

import java.io.Serializable

data class SearchMoviesModel(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<SearchMovieModel>
) : Serializable
