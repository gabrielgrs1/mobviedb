package com.gabrielgrs.moviedb.presentation.model.moviedetail

import java.util.Date

class MovieDetail(
    val adult: Boolean,
    val budget: Int,
    val homepage: String?,
    val posterPath: String?,
    val overview: String?,
    val releaseDate: Date,
    val id: Int,
    val imdbId: String?,
    val originalTitle: String,
    val originalLanguage: String,
    val status: String,
    val tagline: String?,
    val title: String,
    val backdropPath: String?,
    val popularity: Double,
    val revenue: Int,
    val runtime: Int?,
    var voteCount: Int,
    val video: Boolean,
    val productionCompanies: List<ProductionCompanies>,
    val productionCountries: List<ProductionCountries>,
    val spokenLanguages: List<SpokenLanguages>,
    val voteAverage: Double
)