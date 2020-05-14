package com.gabrielgrs.moviedb.core.di

import com.gabrielgrs.moviedb.core.api.provideMoviesApi
import com.gabrielgrs.moviedb.core.api.provideRetrofit
import com.gabrielgrs.moviedb.data.api.repository.MoviesRepositoryImpl
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.usecase.MovieDetailUseCase
import com.gabrielgrs.moviedb.domain.usecase.PopularMoviesUseCase
import com.gabrielgrs.moviedb.domain.usecase.SearchMoviesUseCase
import com.gabrielgrs.moviedb.domain.usecase.SimilarMoviesUseCase
import com.gabrielgrs.moviedb.presentation.ui.moviedetail.MovieDetailFragment
import com.gabrielgrs.moviedb.presentation.ui.moviedetail.MovieDetailViewModel
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesFragment
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesViewModel
import com.gabrielgrs.moviedb.presentation.ui.searchmovies.SearchMoviesFragment
import com.gabrielgrs.moviedb.presentation.ui.searchmovies.SearchMoviesViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

// TODO Entender pra que implementar o factory do fragment
val fragmentModule = module {
    factory { PopularMoviesFragment() }
    factory { MovieDetailFragment() }
    factory { SearchMoviesFragment() }
}

val viewModelModule = module {
    viewModel { PopularMoviesViewModel() }
    viewModel { MovieDetailViewModel() }
    viewModel { SearchMoviesViewModel() }
}

val repositoryModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl() }
}

val networkModule = module {
    factory { provideMoviesApi(get()) }
    single { provideRetrofit() }
}

val useCaseModule = module {
    factory { PopularMoviesUseCase() }
    factory { MovieDetailUseCase() }
    factory { SimilarMoviesUseCase() }
    factory { SearchMoviesUseCase() }
}