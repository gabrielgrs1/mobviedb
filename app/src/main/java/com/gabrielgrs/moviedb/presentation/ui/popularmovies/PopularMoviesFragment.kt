package com.gabrielgrs.moviedb.presentation.ui.popularmovies

import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.plataform.BaseFragment
import com.gabrielgrs.moviedb.core.plataform.fold
import com.gabrielgrs.moviedb.databinding.FragmentPopularMoviesBinding
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovie
import com.gabrielgrs.moviedb.presentation.model.popularmovies.PopularMovies
import com.gabrielgrs.moviedb.presentation.ui.common.MoviesListener
import com.gabrielgrs.moviedb.presentation.ui.moviedetail.MovieDetailFragment
import kotlinx.android.synthetic.main.fragment_popular_movies.popularMoviesListMoviesRv
import kotlinx.android.synthetic.main.fragment_popular_movies.popularMoviesRefreshSrl
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : BaseFragment<FragmentPopularMoviesBinding>(), MoviesListener,
    SwipeRefreshLayout.OnRefreshListener {

    private val popularMoviesViewModel: PopularMoviesViewModel by viewModel()
    private lateinit var adapter: PopularMoviesAdapter
    private lateinit var movies: PopularMovies
    private var page: Int = 1
    private val completeMovieList: MutableList<PopularMovie> = mutableListOf()

    companion object {
        fun newInstance() = PopularMoviesFragment()
    }

    override fun getContentLayoutId(): Int = R.layout.fragment_popular_movies

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
        initRecyclerView()
        getPopularMovies()
        subscribeLiveData()
        initSwipeRefreshLayout()
    }

    private fun initSwipeRefreshLayout() {
        popularMoviesRefreshSrl.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        page = 1
        getPopularMovies()
    }

    private fun initRecyclerView() {
        adapter = PopularMoviesAdapter(listener = this)
        popularMoviesListMoviesRv.layoutManager = GridLayoutManager(requireContext(), 3)
        popularMoviesListMoviesRv.adapter = adapter
        initScrollChangeListener()
    }

    private fun initScrollChangeListener() {
        popularMoviesListMoviesRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(@NonNull recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    if (page < movies.totalPages) {
                        page++
                        getPopularMovies()
                    }
                }
            }
        })
    }

    private fun getPopularMovies() {
        popularMoviesViewModel.getPopularMovies(page)
    }

    private fun subscribeLiveData() {
        popularMoviesViewModel.moviesListResponse.observe(this, Observer { response ->
            response?.fold(this::handleError, this::handleSuccess)
        })
    }

    private fun handleSuccess(response: PopularMovies) {
        movies = response

        if (movies.page == 1) {
            completeMovieList.clear()
        }

        completeMovieList.addAll(movies.results)

        if (popularMoviesRefreshSrl.isRefreshing) {
            popularMoviesRefreshSrl.isRefreshing = false
        }

        adapter.setMovieList(completeMovieList)
        page = movies.page
    }
}
