package com.gabrielgrs.moviedb.presentation.mapper.similarmovie

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.similarmovie.SimilarMovieModel
import com.gabrielgrs.moviedb.presentation.model.similarmovies.SimilarMovie

object SimilarMovieMapper : BaseMapper<SimilarMovieModel, SimilarMovie>() {

    override fun transformFrom(s: SimilarMovie): SimilarMovieModel = SimilarMovieModel(
        title = s.title,
        posterPath = s.posterPath
    )

    override fun transformTo(s: SimilarMovieModel): SimilarMovie =
        SimilarMovie(
            title = s.title,
            posterPath = s.posterPath
        )
}