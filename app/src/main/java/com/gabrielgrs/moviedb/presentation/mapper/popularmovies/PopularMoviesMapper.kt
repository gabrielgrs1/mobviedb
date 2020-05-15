package com.gabrielgrs.moviedb.presentation.mapper.popularmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.movie.PopularMoviesModel
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovies

object PopularMoviesMapper : BaseMapper<PopularMoviesModel, PopularMovies>() {
    override fun transformFrom(s: PopularMovies): PopularMoviesModel =
        PopularMoviesModel(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { PopularMovieMapper.transformFrom(it) },
            totalResults = s.totalResults
        )

    override fun transformTo(s: PopularMoviesModel): PopularMovies =
        PopularMovies(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { PopularMovieMapper.transformTo(it) },
            totalResults = s.totalResults
        )
}