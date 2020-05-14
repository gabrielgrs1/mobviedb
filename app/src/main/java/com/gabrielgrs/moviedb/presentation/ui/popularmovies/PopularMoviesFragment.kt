package com.gabrielgrs.moviedb.presentation.ui.popularmovies

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.plataform.BaseFragment
import com.gabrielgrs.moviedb.core.plataform.fold
import com.gabrielgrs.moviedb.databinding.FragmentPopularMoviesBinding
import com.gabrielgrs.moviedb.presentation.model.movie.PopularMovies
import kotlinx.android.synthetic.main.fragment_popular_movies.popularMoviesListMoviesRv
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : BaseFragment<FragmentPopularMoviesBinding>(), MovieClickListener {

    private val popularMoviesViewModel: PopularMoviesViewModel by viewModel()
    private lateinit var adapter: PopularMoviesAdapter
    private lateinit var movies: PopularMovies
    private var page: Int = 0

    companion object {
        fun newInstance() =
            PopularMoviesFragment()
    }

    override fun getContentLayoutId(): Int = R.layout.fragment_popular_movies

    override fun init() {
        initRecyclerView()
        getPopularMovies()
        subscribeLiveData()
    }

    private fun initRecyclerView() {
        adapter = PopularMoviesAdapter(listener = this)
        popularMoviesListMoviesRv.layoutManager = GridLayoutManager(requireContext(), 3)
        popularMoviesListMoviesRv.adapter = adapter
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
        adapter.setMovieList(movies.results)
        page = movies.page
    }

    override fun onClickMovie(movieId: Int) {
        TODO("Not yet implemented")
    }
}
// TODO Implementar refresh layout
// TODO Implementar observer do scroll da tela
