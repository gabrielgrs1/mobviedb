package com.gabrielgrs.moviedb.data.database.repository

import android.annotation.SuppressLint
import com.gabrielgrs.moviedb.data.database.dao.FavoriteMoviesDao
import com.gabrielgrs.moviedb.data.database.entity.MovieEntity
import com.gabrielgrs.moviedb.domain.repository.FavoriteMoviesRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavoriteMoviesRepositoryImpl(private val favoriteMoviesDao: FavoriteMoviesDao) :
    FavoriteMoviesRepository {
    @SuppressLint("CheckResult")
    override fun isMovieFavorite(movieId: Int): Observable<List<MovieEntity>> =
        favoriteMoviesDao.getFavoriteMovie(movieId)


    @SuppressLint("CheckResult")
    override fun toggleMovieFavorite(movieId: Int, favorite: Boolean): Observable<Boolean> {
        return if (favorite) {
            Observable.fromCallable {
                favoriteMoviesDao.removeFavorite(MovieEntity(movieId))
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
            Observable.just(false)
        } else {
            Observable.fromCallable {
                favoriteMoviesDao.addToFavorites(MovieEntity(movieId))
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
            Observable.just(true)
        }
    }
}