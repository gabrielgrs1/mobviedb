package com.gabrielgrs.moviedb.domain.model.moviedetail

data class ProductionCompaniesModel(
    val id: Int,
    val name: String,
    val logoPath: String?,
    val originalCountry: String
)