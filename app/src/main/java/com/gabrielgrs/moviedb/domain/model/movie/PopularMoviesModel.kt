package com.gabrielgrs.moviedb.domain.model.movie

import java.io.Serializable

data class PopularMoviesModel(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<PopularMovieModel>
) : Serializable

