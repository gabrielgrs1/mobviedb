package com.gabrielgrs.moviedb.presentation.mapper.popularmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.movie.PopularMovieModel
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovie

object PopularMovieMapper :
    BaseMapper<PopularMovieModel, PopularMovie>() {

    override fun transformFrom(s: PopularMovie): PopularMovieModel = PopularMovieModel(
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
        title = s.title,
        video = s.video,
        voteAverage = s.voteAverage,
        voteCount = s.voteCount
    )

    override fun transformTo(s: PopularMovieModel): PopularMovie = PopularMovie(
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
        title = s.title,
        video = s.video,
        voteAverage = s.voteAverage,
        voteCount = s.voteCount
    )
}