package com.gabrielgrs.moviedb.presentation.ui.moviedetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.util.Constants
import com.gabrielgrs.moviedb.presentation.model.similarmovies.SimilarMovie
import kotlinx.android.synthetic.main.item_similar_movie.view.itemSimilarMovieBannerMovieIv
import kotlinx.android.synthetic.main.item_similar_movie.view.itemSimilarMovieTitleTv

class MovieDetailAdapter(private var movieList: List<SimilarMovie>? = null) :
    RecyclerView.Adapter<MovieDetailAdapter.SimilarMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_similar_movie, parent, false)
        return SimilarMoviesViewHolder(view)
    }

    override fun getItemCount(): Int =
        if (movieList.isNullOrEmpty()) {
            0
        } else {
            movieList!!.size
        }

    override fun onBindViewHolder(holder: SimilarMoviesViewHolder, position: Int) {
        val movie = movieList?.get(position)
        movie?.let { holder.bindView(it) }
    }

    fun setMovieList(movieList: List<SimilarMovie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class SimilarMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(similarMovie: SimilarMovie) {
            itemView.itemSimilarMovieTitleTv.text = similarMovie.title

            val imageUrl = Constants.THE_MOVIE_DB_IMAGE_URL + similarMovie.posterPath
            Glide.with(itemView.context)
                .load(imageUrl)
                .thumbnail(0.05f)
                .into(itemView.itemSimilarMovieBannerMovieIv)
        }
    }
}