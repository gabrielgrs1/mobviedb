package com.gabrielgrs.moviedb.data.mapper.similarmovie

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.similarmovies.SimilarMoviesResponse
import com.gabrielgrs.moviedb.domain.model.similarmovie.SimilarMoviesModel

object SimilarMoviesMapper : BaseMapper<SimilarMoviesResponse, SimilarMoviesModel>() {
    override fun transformFrom(s: SimilarMoviesModel): SimilarMoviesResponse =
        SimilarMoviesResponse(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { SimilarMovieMapper.transformFrom(it) },
            totalResults = s.totalResults
        )

    override fun transformTo(s: SimilarMoviesResponse): SimilarMoviesModel =
        SimilarMoviesModel(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { SimilarMovieMapper.transformTo(it) },
            totalResults = s.totalResults
        )
}