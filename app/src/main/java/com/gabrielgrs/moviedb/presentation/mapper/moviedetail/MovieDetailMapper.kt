package com.gabrielgrs.moviedb.presentation.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.MovieDetailResponse
import com.gabrielgrs.moviedb.domain.model.moviedetail.MovieDetailModel
import com.gabrielgrs.moviedb.presentation.model.moviedetail.MovieDetail

object MovieDetailMapper : BaseMapper<MovieDetailModel, MovieDetail>() {
    override fun transformFrom(s: MovieDetail): MovieDetailModel = MovieDetailModel(
        adult = s.adult,
        voteCount = s.voteCount,
        voteAverage = s.voteAverage,
        video = s.video,
        title = s.title,
        releaseDate = s.releaseDate,
        posterPath = s.posterPath,
        overview = s.overview,
        originalTitle = s.originalTitle,
        originalLanguage = s.originalLanguage,
        id = s.id,
        backdropPath = s.backdropPath,
        popularity = s.popularity,
        budget = s.budget,
        genre = s.genre,
        homepage = s.homepage,
        imdbId = s.imdbId,
        productionCompanies = s.productionCompanies,
        productionCountries = s.productionCountries,
        revenue = s.revenue,
        runtime = s.runtime,
        spokenLanguages = s.spokenLanguages,
        status = s.status,
        tagline = s.tagline
    )

    override fun transformTo(s: MovieDetailModel): MovieDetail = MovieDetail(
        adult = s.adult,
        voteCount = s.voteCount,
        voteAverage = s.voteAverage,
        video = s.video,
        title = s.title,
        releaseDate = s.releaseDate,
        posterPath = s.posterPath,
        overview = s.overview,
        originalTitle = s.originalTitle,
        originalLanguage = s.originalLanguage,
        id = s.id,
        backdropPath = s.backdropPath,
        popularity = s.popularity,
        budget = s.budget,
        genre = s.genre,
        homepage = s.homepage,
        imdbId = s.imdbId,
        productionCompanies = s.productionCompanies,
        productionCountries = s.productionCountries,
        revenue = s.revenue,
        runtime = s.runtime,
        spokenLanguages = s.spokenLanguages,
        status = s.status,
        tagline = s.tagline
    )

}