package com.gabrielgrs.moviedb.core.di

import com.gabrielgrs.moviedb.core.api.provideMoviesApi
import com.gabrielgrs.moviedb.core.api.provideRetrofit
import com.gabrielgrs.moviedb.data.api.repository.MoviesRepositoryImpl
import com.gabrielgrs.moviedb.domain.repository.MoviesRepository
import com.gabrielgrs.moviedb.domain.usecase.PopularMoviesUseCase
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesFragment
import com.gabrielgrs.moviedb.presentation.ui.popularmovies.PopularMoviesViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val fragmentModule = module {
    factory { PopularMoviesFragment() }
}

val viewModelModule = module {
    viewModel { PopularMoviesViewModel() }
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
}