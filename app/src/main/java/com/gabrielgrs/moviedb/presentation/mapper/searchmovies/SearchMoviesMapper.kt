package com.gabrielgrs.moviedb.presentation.mapper.searchmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.domain.model.searchmovies.SearchMoviesModel
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovies

object SearchMoviesMapper : BaseMapper<SearchMoviesModel, SearchMovies>() {

    override fun transformFrom(s: SearchMovies): SearchMoviesModel = SearchMoviesModel(
        page = s.page,
        totalPages = s.totalPages,
        results = s.results.map { SearchMovieMapper.transformFrom(it) },
        totalResults = s.totalResults
    )

    override fun transformTo(s: SearchMoviesModel): SearchMovies = SearchMovies(
        page = s.page,
        totalPages = s.totalPages,
        results = s.results.map { SearchMovieMapper.transformTo(it) },
        totalResults = s.totalResults
    )

}