package com.gabrielgrs.moviedb.presentation.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.moviedetail.SpokenLanguagesModel
import com.gabrielgrs.moviedb.presentation.model.moviedetail.SpokenLanguages

object SpokenLanguagesMapper : BaseMapper<SpokenLanguagesModel, SpokenLanguages>() {

    override fun transformFrom(s: SpokenLanguages): SpokenLanguagesModel = SpokenLanguagesModel(
        name = s.name,
        iso6931 = s.iso6931
    )

    override fun transformTo(s: SpokenLanguagesModel): SpokenLanguages = SpokenLanguages(
        name = s.name,
        iso6931 = s.iso6931
    )
}