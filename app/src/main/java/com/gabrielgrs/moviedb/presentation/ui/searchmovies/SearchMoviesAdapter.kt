package com.gabrielgrs.moviedb.presentation.ui.searchmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.util.Constants
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovie
import com.gabrielgrs.moviedb.presentation.ui.common.MoviesListener
import kotlinx.android.synthetic.main.item_movie.view.itemPopularMovieBannerMovieIv
import kotlinx.android.synthetic.main.item_movie.view.itemPopularMovieTextRatingTv
import kotlinx.android.synthetic.main.item_movie.view.itemPopularMovieTitleTv

class SearchMoviesAdapter(
    private var movieList: List<SearchMovie>? = null,
    private val listener: MoviesListener
) : RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return SearchMoviesViewHolder(view)
    }

    override fun getItemCount(): Int =
        if (movieList.isNullOrEmpty()) {
            0
        } else {
            movieList!!.size
        }

    override fun onBindViewHolder(holder: SearchMoviesViewHolder, position: Int) {
        val movie = movieList?.get(position)
        movie?.let { holder.bindView(it) }

        holder.itemView.setOnClickListener {
            if (movie != null) {
                listener.onClickMovie(movie.id)
            }
        }
    }

    fun setMovieList(movieList: List<SearchMovie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class SearchMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(searchMovie: SearchMovie) {
            setTextFields(searchMovie)
            setImage(searchMovie.posterPath)
        }

        private fun setTextFields(searchMovie: SearchMovie) {
            itemView.itemPopularMovieTitleTv.text = searchMovie.title
            itemView.itemPopularMovieTextRatingTv.text = searchMovie.voteAverage.toString()
        }

        private fun setImage(posterPath: String?) {
            if (posterPath != null) {
                val imageUrl = Constants.THE_MOVIE_DB_IMAGE_URL + posterPath
                Glide.with(itemView.context)
                    .load(imageUrl)
                    .thumbnail(0.05f)
                    .into(itemView.itemPopularMovieBannerMovieIv)
            }
        }
    }
}