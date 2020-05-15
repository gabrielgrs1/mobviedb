package com.gabrielgrs.moviedb.data.database.repository

import com.gabrielgrs.moviedb.data.database.dao.FavoriteMoviesDao
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavoriteMoviesRepositoryImpl(private val favoriteMoviesDao: FavoriteMoviesDao) :
    FavoriteMoviesRepository {
    override fun isMovieFavorite(movieId: Int): Boolean {
        var isFavorite = false

        Observable.fromCallable {
            favoriteMoviesDao.getFavoriteMovie(movieId)
        }.doOnNext { movie ->
            isFavorite = movie != null
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        return isFavorite
    }

    override fun toggleMovieFavorite(movieId: Int) {
        val isFavorite = isMovieFavorite(movieId)

        if (isFavorite) {
            Observable.fromCallable {
                favoriteMoviesDao.removeFavorite(MovieEntity(movieId))
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        } else {
            Observable.fromCallable {
                favoriteMoviesDao.addToFavorites(MovieEntity(movieId))
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        }
    }
}