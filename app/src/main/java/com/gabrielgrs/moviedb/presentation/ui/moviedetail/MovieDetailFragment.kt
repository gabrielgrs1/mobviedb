package com.gabrielgrs.moviedb.presentation.ui.moviedetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.plataform.BaseFragment
import com.gabrielgrs.moviedb.core.plataform.fold
import com.gabrielgrs.moviedb.core.util.Constants
import com.gabrielgrs.moviedb.databinding.FragmentMovieDetailBinding
import com.gabrielgrs.moviedb.presentation.model.moviedetail.MovieDetail
import com.gabrielgrs.moviedb.presentation.model.similarmovies.SimilarMovies
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailBackPosterIv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailCompaniesTv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailFavoriteIv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailOverViewTv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailSimilarMoviesRv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailTitleTv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailWebsiteTv
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDetailYearTv
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    private val movieDetailViewModel: MovieDetailViewModel by viewModel()
    private var mMovieId: Int = 0
    private lateinit var adapter: MovieDetailAdapter

    companion object {
        const val MOVIE_ID_KEY = "MOVIE_ID"

        fun newInstance(movieId: Int): MovieDetailFragment {
            val bundle = Bundle()
            bundle.putInt(MOVIE_ID_KEY, movieId)
            val fragment = MovieDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getContentLayoutId(): Int = R.layout.fragment_movie_detail

    override fun init() {
        getMovieId()
        subscribeLiveData()
        initRecyclerView()
        getMovieDetail()
        getSimilarMovies()
        initOnClickListener()
    }

    private fun initOnClickListener() {
        movieDetailFavoriteIv.setOnClickListener { toggleFavoriteMovie() }
    }

    private fun getMovieId() {
        arguments?.let {
            mMovieId = it.getInt(MOVIE_ID_KEY)
        }
    }

    private fun getMovieDetail() {
        movieDetailViewModel.getMovieDetail(mMovieId)
    }

    private fun getSimilarMovies() {
        movieDetailViewModel.getSimilarMovies(mMovieId)
    }

    private fun getIsFavoriteMovie() {
        movieDetailViewModel.isMovieFavorite(mMovieId)
    }


    private fun toggleFavoriteMovie() {
        movieDetailViewModel.isMovieFavorite(mMovieId)
    }

    private fun subscribeLiveData() {
        movieDetailViewModel.movieDetailResponse.observe(this, Observer { response ->
            response?.fold(this::handleError, this::handleDetailSuccess)
        })

        movieDetailViewModel.similarMoviesResponse.observe(this, Observer { response ->
            response?.fold(this::handleError, this::handleSimilarMovies)
        })

        movieDetailViewModel.isFavoriteMovieResponse.observe(this, Observer { response ->
            response?.let { handleFavoriteMovie(it) }
        })
    }

    private fun handleFavoriteMovie(it: Boolean) {
        if (it) {
            movieDetailFavoriteIv.setImageDrawable(resources.getDrawable(R.drawable.ic_star))
        } else {
            movieDetailFavoriteIv.setImageDrawable(resources.getDrawable(R.drawable.ic_star_unmarked))
        }
    }

    private fun initRecyclerView() {
        adapter = MovieDetailAdapter()
        movieDetailSimilarMoviesRv.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        movieDetailSimilarMoviesRv.adapter = adapter
    }

    private fun handleDetailSuccess(response: MovieDetail) {
        initMovieDetails(response)
        getIsFavoriteMovie()
    }

    private fun handleSimilarMovies(response: SimilarMovies) {
        adapter.setMovieList(response.results)
    }

    private fun initMovieDetails(response: MovieDetail) {
        movieDetailTitleTv.text = response.title
        movieDetailWebsiteTv.text = response.homepage
        movieDetailOverViewTv.text = response.overview
        setCompanies(response)
        setReleaseDate(response)
        setMovieBackbanner(response)
    }

    private fun setMovieBackbanner(response: MovieDetail) {
        val imageUrl = Constants.THE_MOVIE_DB_IMAGE_URL + response.backdropPath
        Glide.with(requireContext())
            .load(imageUrl)
            .thumbnail(0.05f)
            .into(movieDetailBackPosterIv)
    }

    private fun setCompanies(response: MovieDetail) {
        var companies = ""
        response.productionCompanies.forEach {
            companies += "- ${it.name}\n"
        }
        movieDetailCompaniesTv.text = companies
    }

    private fun setReleaseDate(response: MovieDetail) {
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyy")
        val releaseDate = simpleDateFormat.format(response.releaseDate)
        movieDetailYearTv.text = releaseDate
    }
}
