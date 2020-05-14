package com.gabrielgrs.moviedb.data.mapper.similarmovie

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.similarmovies.SimilarMovieResponse
import com.gabrielgrs.moviedb.domain.model.similarmovie.SimilarMovieModel

object SimilarMovieMapper : BaseMapper<SimilarMovieResponse, SimilarMovieModel>() {

    override fun transformFrom(s: SimilarMovieModel): SimilarMovieResponse = SimilarMovieResponse(
        title = s.title,
        posterPath = s.posterPath
    )

    override fun transformTo(s: SimilarMovieResponse): SimilarMovieModel = SimilarMovieModel(
        title = s.title,
        posterPath = s.posterPath
    )
}