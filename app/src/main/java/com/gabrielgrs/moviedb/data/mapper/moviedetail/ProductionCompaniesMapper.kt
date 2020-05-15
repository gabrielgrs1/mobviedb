package com.gabrielgrs.moviedb.data.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.ProductionCompaniesResponse
import com.gabrielgrs.moviedb.domain.model.moviedetail.ProductionCompaniesModel

object ProductionCompaniesMapper :
    BaseMapper<ProductionCompaniesResponse, ProductionCompaniesModel>() {
    override fun transformFrom(s: ProductionCompaniesModel): ProductionCompaniesResponse =
        ProductionCompaniesResponse(
            id = s.id,
            name = s.name,
            logoPath = s.logoPath,
            originCountry = s.originalCountry
        )

    override fun transformTo(s: ProductionCompaniesResponse): ProductionCompaniesModel =
        ProductionCompaniesModel(
            id = s.id,
            name = s.name,
            logoPath = s.logoPath,
            originalCountry = s.originCountry
        )
}