package com.gabrielgrs.moviedb.domain.model.moviedetail

import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.Genre
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.ProductionCompanies
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.ProductionCountries
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.SpokenLanguages
import java.util.Date

class MovieDetailModel(
    val adult: Boolean,
    val belongsToCollection: Any?,
    val budget: Int,
    val homepage: String?,
    val posterPath: String?,
    val overview: String?,
    val releaseDate: Date,
    val genre: List<Genre>,
    val id: Int,
    val imdbId: Int?,
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