package com.gabrielgrs.moviedb.presentation.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.moviedetail.ProductionCompaniesModel
import com.gabrielgrs.moviedb.presentation.model.moviedetail.ProductionCompanies

object ProductionCompaniesMapper : BaseMapper<ProductionCompaniesModel, ProductionCompanies>() {
    override fun transformFrom(s: ProductionCompanies): ProductionCompaniesModel =
        ProductionCompaniesModel(
            id = s.id,
            name = s.name,
            logoPath = s.logoPath,
            originalCountry = s.originalCountry
        )

    override fun transformTo(s: ProductionCompaniesModel): ProductionCompanies =
        ProductionCompanies(
            id = s.id,
            name = s.name,
            logoPath = s.logoPath,
            originalCountry = s.originalCountry
        )
}