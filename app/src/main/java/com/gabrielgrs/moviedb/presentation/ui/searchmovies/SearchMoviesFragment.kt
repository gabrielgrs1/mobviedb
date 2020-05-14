package com.gabrielgrs.moviedb.presentation.ui.searchmovies

import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.plataform.BaseFragment
import com.gabrielgrs.moviedb.core.plataform.fold
import com.gabrielgrs.moviedb.databinding.FragmentSearchMoviesBinding
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovie
import com.gabrielgrs.moviedb.presentation.model.searchmovies.SearchMovies
import com.gabrielgrs.moviedb.presentation.ui.common.MoviesListener
import com.gabrielgrs.moviedb.presentation.ui.moviedetail.MovieDetailFragment
import kotlinx.android.synthetic.main.fragment_search_movies.searchMoviesListMoviesRv
import kotlinx.android.synthetic.main.fragment_search_movies.searchMoviesSearchEt
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Timer
import java.util.TimerTask


class SearchMoviesFragment : BaseFragment<FragmentSearchMoviesBinding>(), MoviesListener {

    private val mSearchMoviesViewModel: SearchMoviesViewModel by viewModel()
    private lateinit var mAdapter: SearchMoviesAdapter
    private lateinit var mMovies: SearchMovies
    private lateinit var mQuery: String
    private var mPage: Int = 1
    private val mCompleteMovieList: MutableList<SearchMovie> = mutableListOf()

    companion object {
        fun newInstance() = SearchMoviesFragment()
    }

    override fun getContentLayoutId(): Int = R.layout.fragment_search_movies

    override fun onClickMovie(movieId: Int) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                R.id.mainContent,
                MovieDetailFragment.newInstance(movieId),
                MovieDetailFragment::class.simpleName
            )
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun init() {
        initTextChangeListener()
        initRecyclerView()
        subscribeLiveData()
    }

    private fun initTextChangeListener() {
        searchMoviesSearchEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                getQuery(editable)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    private fun getQuery(editable: Editable?) {
        if (!editable.isNullOrEmpty()) {
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    mPage = 1
                    searchMovies(editable.toString())
                }
            }, 600)
        }
    }

    private fun initRecyclerView() {
        mAdapter = SearchMoviesAdapter(listener = this)
        searchMoviesListMoviesRv.layoutManager = GridLayoutManager(requireContext(), 3)
        searchMoviesListMoviesRv.adapter = mAdapter
        initScrollChangeListener()
    }

    private fun initScrollChangeListener() {
        searchMoviesListMoviesRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(@NonNull recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                observeScrollEnd(recyclerView)
            }
        })
    }

    private fun observeScrollEnd(recyclerView: RecyclerView) {
        if (!recyclerView.canScrollVertically(1)) {
            if (mPage < mMovies.totalPages) {
                mPage++
                searchMovies(mQuery)
            }
        }
    }

    private fun searchMovies(query: String) {
        mQuery = query
        mSearchMoviesViewModel.searchMovies(query, mPage)
    }

    private fun subscribeLiveData() {
        mSearchMoviesViewModel.moviesListResponse.observe(this, Observer { response ->
            response?.fold(this::handleError, this::handleSuccess)
        })
    }

    private fun handleSuccess(response: SearchMovies) {
        mMovies = response

        if (mMovies.page == 1) {
            mCompleteMovieList.clear()
        }

        mCompleteMovieList.addAll(mMovies.results)

        mAdapter.setMovieList(mCompleteMovieList)
        mPage = mMovies.page
    }
}
