package com.gabrielgrs.moviedb.data.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.SpokenLanguagesResponse
import com.gabrielgrs.moviedb.domain.model.moviedetail.SpokenLanguagesModel

object SpokenLanguagesMapper : BaseMapper<SpokenLanguagesResponse, SpokenLanguagesModel>() {

    override fun transformFrom(s: SpokenLanguagesModel): SpokenLanguagesResponse =
        SpokenLanguagesResponse(
            name = s.name,
            iso6931 = s.iso6931
        )

    override fun transformTo(s: SpokenLanguagesResponse): SpokenLanguagesModel =
        SpokenLanguagesModel(
            name = s.name,
            iso6931 = s.iso6931
        )
}