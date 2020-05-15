package com.gabrielgrs.moviedb.presentation.ui.popularmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.util.Constants
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovie
import com.gabrielgrs.moviedb.presentation.ui.common.MoviesListener
import kotlinx.android.synthetic.main.item_movie.view.itemPopularMovieBannerMovieIv
import kotlinx.android.synthetic.main.item_movie.view.itemPopularMovieTextRatingTv
import kotlinx.android.synthetic.main.item_movie.view.itemPopularMovieTitleTv

class PopularMoviesAdapter(
    private var movieList: List<PopularMovie>? = null,
    private val listener: MoviesListener
) : RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return PopularMoviesViewHolder(view)
    }

    override fun getItemCount(): Int =
        if (movieList.isNullOrEmpty()) {
            0
        } else {
            movieList!!.size
        }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val movie = movieList?.get(position)
        movie?.let { holder.bindView(it) }

        holder.itemView.setOnClickListener {
            if (movie != null) {
                listener.onClickMovie(movie.id)
            }
        }
    }

    fun setMovieList(movieList: List<PopularMovie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class PopularMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(popularMovie: PopularMovie) {
            setTextFields(popularMovie)

            setImage(popularMovie.posterPath)
        }

        private fun setImage(posterPath: String?) {
            if (posterPath != null) {
                val imageUrl = Constants.THE_MOVIE_DB_IMAGE_URL + posterPath
                Glide.with(itemView.context)
                    .load(imageUrl)
                    .thumbnail(0.02f)
                    .into(itemView.itemPopularMovieBannerMovieIv)
            }
        }

        private fun setTextFields(popularMovie: PopularMovie) {
            itemView.itemPopularMovieTitleTv.text = popularMovie.title
            itemView.itemPopularMovieTextRatingTv.text = popularMovie.voteAverage.toString()
        }
    }
}