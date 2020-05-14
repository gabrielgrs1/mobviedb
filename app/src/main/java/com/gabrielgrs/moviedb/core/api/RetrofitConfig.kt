package com.gabrielgrs.moviedb.core.api

import com.gabrielgrs.moviedb.core.util.Constants
import com.gabrielgrs.moviedb.core.util.Constants.Companion.API_KEY
import com.gabrielgrs.moviedb.core.util.Constants.Companion.THE_MOVIE_DB_BASE_URL
import com.gabrielgrs.moviedb.data.api.service.IApiService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


fun provideMoviesApi(retrofit: Retrofit): IApiService = retrofit.create(IApiService::class.java)

fun provideRetrofit(): Retrofit {
    lateinit var retrofit: Retrofit
    val client = OkHttpClient.Builder()
    addQueryParameters(client)
    addLoggingInterceptor(client)

    val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        .create()

    retrofit = Retrofit.Builder()
        .baseUrl(THE_MOVIE_DB_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client.build())
        .build()

    return retrofit
}

private fun addLoggingInterceptor(client: OkHttpClient.Builder) {
    client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
}

private fun addQueryParameters(client: OkHttpClient.Builder) {
    client.addInterceptor(object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val url = chain.request().url.newBuilder()
                .addQueryParameter(Constants.API_KEY_QUERY, API_KEY)
                .build()

            val request = chain.request().newBuilder().url(url).build()
            return chain.proceed(request)
        }
    })
}

