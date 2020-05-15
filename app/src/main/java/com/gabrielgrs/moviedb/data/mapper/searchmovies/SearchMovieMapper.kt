package com.gabrielgrs.moviedb.data.mapper.searchmovies

import android.annotation.SuppressLint
import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.searchmovies.SearchMovieResponse
import com.gabrielgrs.moviedb.domain.model.searchmovies.SearchMovieModel
import java.text.SimpleDateFormat
import java.util.Date

object SearchMovieMapper : BaseMapper<SearchMovieResponse, SearchMovieModel>() {

    @SuppressLint("SimpleDateFormat")
    override fun transformFrom(s: SearchMovieModel): SearchMovieResponse = SearchMovieResponse(
        popularity = s.popularity,
        adult = s.adult,
        backdropPath = s.backdropPath,
        genreIdes = s.genreIdes,
        id = s.id,
        originalLanguage = s.originalLanguage,
        originalTitle = s.originalTitle,
        overview = s.overview,
        posterPath = s.posterPath,
        releaseDate = SimpleDateFormat("dd-MM-yyy").format(s.releaseDate),
        title = s.title,
        video = s.video,
        voteAverage = s.voteAverage,
        voteCount = s.voteCount
    )

    override fun transformTo(s: SearchMovieResponse): SearchMovieModel = SearchMovieModel(
        popularity = s.popularity,
        adult = s.adult,
        backdropPath = s.backdropPath,
        genreIdes = s.genreIdes,
        id = s.id,
        originalLanguage = s.originalLanguage,
        originalTitle = s.originalTitle,
        overview = s.overview,
        posterPath = s.posterPath,
        releaseDate = getDate(s.releaseDate),
        title = s.title,
        video = s.video,
        voteAverage = s.voteAverage,
        voteCount = s.voteCount
    )

    @SuppressLint("SimpleDateFormat")
    private fun getDate(releaseDate: String): Date {
        var date = Date()
        if (releaseDate.isNotEmpty()) {
            date = SimpleDateFormat("dd-MM-yyy").parse(releaseDate)
        }
        return date
    }
}