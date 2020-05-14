package com.gabrielgrs.moviedb.presentation.model.movie

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.gabrielgrs.moviedb.BR
import java.util.Date

data class PopularMovie(
    var _posterPath: String?,
    var _overview: String,
    var _adult: Boolean,
    var _releaseDate: Date,
    var _genreIdes: List<Int>,
    var _id: Int,
    var _originalTitle: String,
    var _originalLanguage: String,
    var _title: String,
    var _backdropPath: String?,
    var _popularity: Double,
    var _voteCount: Int,
    var _video: Boolean,
    var _voteAverage: Double
) : BaseObservable() {
    @Bindable
    var posterPath: String = ""
        set(value) {
            notifyPropertyChanged(BR.posterPath)
            _posterPath = value
            field = value
        }

    @Bindable
    var overview: String = ""
        set(value) {
            notifyPropertyChanged(BR.overview)
            _overview = value
            field = value
        }

    @Bindable
    var adult: Boolean = false
        set(value) {
            notifyPropertyChanged(BR.adult)
            _adult = value
            field = value
        }

    @Bindable
    var releaseDate: Date = Date()
        set(value) {
            notifyPropertyChanged(BR.releaseDate)
            _releaseDate = value
            field = value
        }

    @Bindable
    var genreIdes: List<Int> = listOf()
        set(value) {
            notifyPropertyChanged(BR.genreIdes)
            _genreIdes = value
            field = value
        }

    @Bindable
    var id: Int = Integer.MIN_VALUE
        set(value) {
            notifyPropertyChanged(BR.id)
            _id = value
            field = value
        }

    @Bindable
    var originalTitle: String = ""
        set(value) {
            notifyPropertyChanged(BR.originalTitle)
            _originalTitle = value
            field = value
        }

    @Bindable
    var originalLanguage: String = ""
        set(value) {
            notifyPropertyChanged(BR.originalLanguage)
            _originalLanguage = value
            field = value
        }

    @Bindable
    var title: String = ""
        set(value) {
            notifyPropertyChanged(BR.title)
            _title = value
            field = value
        }

    @Bindable
    var backdropPath: String = ""
        set(value) {
            notifyPropertyChanged(BR.backdropPath)
            _backdropPath = value
            field = value
        }

    @Bindable
    var popularity: Double = Double.MIN_VALUE
        set(value) {
            notifyPropertyChanged(BR.popularity)
            _popularity = value
            field = value
        }

    @Bindable
    var voteCount: Int = Int.MIN_VALUE
        set(value) {
            notifyPropertyChanged(BR.voteCount)
            _voteCount = value
            field = value
        }

    @Bindable
    var video: Boolean = false
        set(value) {
            notifyPropertyChanged(BR.video)
            _video = value
            field = value
        }

    @Bindable
    var voteAverage: Double = Double.MAX_VALUE
        set(value) {
            notifyPropertyChanged(BR.voteAverage)
            _voteAverage = value
            field = value
        }

    @BindingAdapter("banner")
    fun loadImage(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .thumbnail(0.3f)
            .into(imageView)
    }
}