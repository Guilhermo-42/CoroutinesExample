package com.guiherme.coroutines.di

import com.guiherme.coroutines.BuildConfig
import com.guiherme.coroutines.network.FactsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single { OkHttpClient().newBuilder().addInterceptor(get<HttpLoggingInterceptor>()).build() }
    single {
        Retrofit.Builder().baseUrl(BuildConfig.API_BASE_URL).client(get())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    single { get<Retrofit>().create(FactsApi::class.java) }

}