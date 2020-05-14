package com.gabrielgrs.moviedb.domain.requestvalues

import com.gabrielgrs.moviedb.core.plataform.BaseRequestValues

data class SearchMoviesRequestValues(val query: String, val page: Int) : BaseRequestValues