package com.gabrielgrs.moviedb.presentation.model.searchmovies

import java.util.Date

data class SearchMovie(
    var posterPath: String?,
    var overview: String,
    var adult: Boolean,
    var releaseDate: Date,
    var genreIdes: List<Int>,
    var id: Int,
    var originalTitle: String,
    var originalLanguage: String,
    var title: String,
    var backdropPath: String?,
    var popularity: Double,
    var voteCount: Int,
    var video: Boolean,
    var voteAverage: Double
)