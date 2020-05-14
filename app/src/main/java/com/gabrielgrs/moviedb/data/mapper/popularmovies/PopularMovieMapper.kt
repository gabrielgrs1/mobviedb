package com.gabrielgrs.moviedb.data.mapper.popularmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.movie.MovieResponse
import com.gabrielgrs.moviedb.domain.model.movie.PopularMovieModel

object PopularMovieMapper :
    BaseMapper<MovieResponse, PopularMovieModel>() {

    override fun transformFrom(s: PopularMovieModel): MovieResponse =
        MovieResponse(
            popularity = s.popularity,
            adult = s.adult,
            backdropPath = s.backdropPath,
            genreIdes = s.genreIdes,
            id = s.id,
            originalLanguage = s.originalLanguage,
            originalTitle = s.originalTitle,
            overview = s.overview,
            posterPath = s.posterPath,
            releaseDate = s.releaseDate,
            title = s.originalTitle,
            video = s.video,
            voteAverage = s.voteAverage,
            voteCount = s.voteCount
        )

    override fun transformTo(s: MovieResponse): PopularMovieModel =
        PopularMovieModel(
            popularity = s.popularity,
            adult = s.adult,
            backdropPath = s.backdropPath,
            genreIdes = s.genreIdes,
            id = s.id,
            originalLanguage = s.originalLanguage,
            originalTitle = s.originalTitle,
            overview = s.overview,
            posterPath = s.posterPath,
            releaseDate = s.releaseDate,
            title = s.originalTitle,
            video = s.video,
            voteAverage = s.voteAverage,
            voteCount = s.voteCount
        )
}