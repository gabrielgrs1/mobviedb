package com.gabrielgrs.moviedb.presentation.mapper.searchmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.searchmovies.SearchMovieModel
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovie

object SearchMovieMapper : BaseMapper<SearchMovieModel, SearchMovie>() {

    override fun transformFrom(s: SearchMovie): SearchMovieModel = SearchMovieModel(
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

    override fun transformTo(s: SearchMovieModel): SearchMovie = SearchMovie(
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