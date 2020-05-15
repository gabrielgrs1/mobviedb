package com.gabrielgrs.moviedb.data.mapper.moviedetail

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.moviedetail.MovieDetailResponse
import com.gabrielgrs.moviedb.domain.model.moviedetail.MovieDetailModel

object MovieDetailMapper : BaseMapper<MovieDetailResponse, MovieDetailModel>() {
    override fun transformFrom(s: MovieDetailModel): MovieDetailResponse =
        MovieDetailResponse(
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
            genre = s.genre?.let { GenreMapper.transformFromList(it) },
            homepage = s.homepage,
            imdbId = s.imdbId,
            productionCompany = ProductionCompaniesMapper.transformFromList(s.productionCompanies),
            productionCountry = ProductionCountriesMapper.transformFromList(s.productionCountries),
            revenue = s.revenue,
            runtime = s.runtime,
            spokenLanguage = SpokenLanguagesMapper.transformFromList(s.spokenLanguages),
            status = s.status,
            tagline = s.tagline
        )

    override fun transformTo(s: MovieDetailResponse): MovieDetailModel =
        MovieDetailModel(
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
            genre = s.genre?.let { GenreMapper.transformToList(it) },
            homepage = s.homepage,
            imdbId = s.imdbId,
            productionCompanies = ProductionCompaniesMapper.transformToList(s.productionCompany),
            productionCountries = ProductionCountriesMapper.transformToList(s.productionCountry),
            revenue = s.revenue,
            runtime = s.runtime,
            spokenLanguages = SpokenLanguagesMapper.transformToList(s.spokenLanguage),
            status = s.status,
            tagline = s.tagline
        )

}