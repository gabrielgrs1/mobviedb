package com.gabrielgrs.moviedb.presentation.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.moviedetail.ProductionCountriesModel
import com.gabrielgrs.moviedb.presentation.model.moviedetail.ProductionCountries

object ProductionCountriesMapper : BaseMapper<ProductionCountriesModel, ProductionCountries>() {

    override fun transformFrom(s: ProductionCountries): ProductionCountriesModel =
        ProductionCountriesModel(
            iso31661 = s.iso31661,
            name = s.name
        )

    override fun transformTo(s: ProductionCountriesModel): ProductionCountries =
        ProductionCountries(
            iso31661 = s.iso31661,
            name = s.name
        )
}