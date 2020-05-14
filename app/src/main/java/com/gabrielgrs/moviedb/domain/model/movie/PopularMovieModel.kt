package com.gabrielgrs.moviedb.domain.model.movie

import java.io.Serializable
import java.util.Date

data class PopularMovieModel(
    val posterPath: String?,
    val overview: String,
    val adult: Boolean,
    val releaseDate: Date,
    val genreIdes: List<Int>,
    val id: Int,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String?,
    val popularity: Double,
    var voteCount: Int,
    val video: Boolean,
    val voteAverage: Double
) : Serializable