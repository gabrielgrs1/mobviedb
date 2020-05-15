package com.gabrielgrs.moviedb.data.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.GenreResponse
import com.gabrielgrs.moviedb.domain.model.moviedetail.GenreModel
import com.gabrielgrs.moviedb.presentation.model.moviedetail.Genre

object GenreMapper : BaseMapper<GenreResponse, GenreModel>() {

    override fun transformFrom(s: GenreModel): GenreResponse = GenreResponse(
        id = s.id,
        name = s.name
    )

    override fun transformTo(s: GenreResponse): GenreModel = GenreModel(
        id = s.id,
        name = s.name
    )
}