package com.gabrielgrs.moviedb.presentation.mapper.similarmovie

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.similarmovie.SimilarMoviesModel
import com.gabrielgrs.moviedb.presentation.model.similarmovies.SimilarMovies

object SimilarMoviesMapper : BaseMapper<SimilarMoviesModel, SimilarMovies>() {

    override fun transformFrom(s: SimilarMovies): SimilarMoviesModel =
        SimilarMoviesModel(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { SimilarMovieMapper.transformFrom(it) },
            totalResults = s.totalResults
        )

    override fun transformTo(s: SimilarMoviesModel): SimilarMovies =
        SimilarMovies(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { SimilarMovieMapper.transformTo(it) },
            totalResults = s.totalResults
        )
}