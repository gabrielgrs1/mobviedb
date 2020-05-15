package com.gabrielgrs.moviedb.domain.requestvalues

import com.gabrielgrs.moviedb.core.plataform.BaseRequestValues

data class FavoriteMoviesRequestValues(val movieId: Int, val isFavorite: Boolean) :
    BaseRequestValues