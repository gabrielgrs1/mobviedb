package com.gabrielgrs.moviedb.presentation.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.moviedetail.GenreModel
import com.gabrielgrs.moviedb.presentation.model.moviedetail.Genre

object GenreMapper : BaseMapper<GenreModel, Genre>() {

    override fun transformFrom(s: Genre): GenreModel = GenreModel(
        id = s.id,
        name = s.name
    )

    override fun transformTo(s: GenreModel): Genre = Genre(
        id = s.id,
        name = s.name
    )
}