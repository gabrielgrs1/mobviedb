package com.gabrielgrs.moviedb.data.mapper.popularmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.movie.MoviesResponse
import com.gabrielgrs.moviedb.domain.model.movie.PopularMoviesModel

object PopularMoviesMapper : BaseMapper<MoviesResponse, PopularMoviesModel>() {
    override fun transformTo(s: MoviesResponse): PopularMoviesModel =
        PopularMoviesModel(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { PopularMovieMapper.transformTo(it) },
            totalResults = s.totalResults
        )

    override fun transformFrom(s: PopularMoviesModel): MoviesResponse =
        MoviesResponse(
            page = s.page,
            totalPages = s.totalPages,
            results = s.results.map { PopularMovieMapper.transformFrom(it) },
            totalResults = s.totalResults
        )
}