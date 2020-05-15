package com.gabrielgrs.moviedb.data.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.ProductionCountriesResponse
import com.gabrielgrs.moviedb.domain.model.moviedetail.ProductionCountriesModel

object ProductionCountriesMapper :
    BaseMapper<ProductionCountriesResponse, ProductionCountriesModel>() {

    override fun transformFrom(s: ProductionCountriesModel): ProductionCountriesResponse =
        ProductionCountriesResponse(
            iso31661 = s.iso31661,
            name = s.name
        )

    override fun transformTo(s: ProductionCountriesResponse): ProductionCountriesModel =
        ProductionCountriesModel(
            iso31661 = s.iso31661,
            name = s.name
        )
}