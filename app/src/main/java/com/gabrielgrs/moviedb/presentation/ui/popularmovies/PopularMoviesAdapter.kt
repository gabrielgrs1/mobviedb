package com.gabrielgrs.moviedb.presentation.ui.popularmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.databinding.ItemPopularMovieBinding
import com.gabrielgrs.moviedb.presentation.model.movie.PopularMovie

class PopularMoviesAdapter(
    private var movieList: List<PopularMovie>? = null,
    private val listener: MovieClickListener
) : RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val popularMoviesListItemBinding: ItemPopularMovieBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_popular_movie,
                parent,
                false
            )
        return PopularMoviesViewHolder(popularMoviesListItemBinding)
    }

    override fun getItemCount(): Int =
        if (movieList.isNullOrEmpty()) {
            0
        } else {
            movieList!!.size
        }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val movie = movieList?.get(position)
        holder.popularMoviesListItemBinding.popularMovie(movie)

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

    class PopularMoviesViewHolder(@NonNull var popularMoviesListItemBinding: ItemPopularMovieBinding) :
        RecyclerView.ViewHolder(popularMoviesListItemBinding.root)
}