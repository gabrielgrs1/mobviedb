package com.gabrielgrs.moviedb.presentation.mapper.popularmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.movie.PopularMovieModel
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovie

object PopularMovieMapper :
    BaseMapper<PopularMovieModel, PopularMovie>() {

    override fun transformFrom(s: PopularMovie): PopularMovieModel =
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
            title = s.title,
            video = s.video,
            voteAverage = s.voteAverage,
            voteCount = s.voteCount
        )

    override fun transformTo(s: PopularMovieModel): PopularMovie {
//        popularMovie.posterPath = s.posterPath
//        popularMovie.popularity = s.popularity
//        popularMovie.adult = s.adult
//        popularMovie.backdropPath = s.backdropPath
//        popularMovie.genreIdes = s.genreIdes
//        popularMovie.id = s.id
//        popularMovie.originalLanguage = s.originalLanguage
//        popularMovie.originalTitle = s.originalTitle
//        popularMovie.title = s.title
//        popularMovie.video = s.video
//        popularMovie.voteAverage = s.voteAverage
//        popularMovie.voteCount = s.voteCount
//        popularMovie.releaseDate = s.releaseDate
//        popularMovie.overview = s.overview

        return PopularMovie(
            _popularity = s.popularity,
            _adult = s.adult,
            _backdropPath = s.backdropPath,
            _genreIdes = s.genreIdes,
            _id = s.id,
            _originalLanguage = s.originalLanguage,
            _originalTitle = s.originalTitle,
            _overview = s.overview,
            _posterPath = s.posterPath,
            _releaseDate = s.releaseDate,
            _title = s.title,
            _video = s.video,
            _voteAverage = s.voteAverage,
            _voteCount = s.voteCount
        )

    }

}