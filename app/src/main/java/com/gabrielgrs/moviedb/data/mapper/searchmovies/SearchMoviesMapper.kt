package com.gabrielgrs.moviedb.data.mapper.searchmovies

import com.gabrielgrs.moviedb.core.plataform.BaseMapper
import com.gabrielgrs.moviedb.data.api.model.response.searchmovies.SearchMoviesResponse
import com.gabrielgrs.moviedb.domain.model.searchmovies.SearchMoviesModel

object SearchMoviesMapper : BaseMapper<SearchMoviesResponse, SearchMoviesModel>() {

    override fun transformFrom(s: SearchMoviesModel): SearchMoviesResponse = SearchMoviesResponse(
        page = s.page,
        totalPages = s.totalPages,
        results = s.results.map { SearchMovieMapper.transformFrom(it) },
        totalResults = s.totalResults
    )

    override fun transformTo(s: SearchMoviesResponse): SearchMoviesModel = SearchMoviesModel(
        page = s.page,
        totalPages = s.totalPages,
        results = s.results.map { SearchMovieMapper.transformTo(it) },
        totalResults = s.totalResults
    )

}