package com.example.netlib.data.di


import android.util.Log
import com.example.netlib.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


// Назначение: Модуль для подлючения к API
// Автор: Дерябина В.Н.
// Дата создания: 25-05-2026

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor =
        HttpLoggingInterceptor{message ->
            Log.d("[NetworkModule]","Логирование - $message")
        }

    @Provides
    @Singleton
    fun provideClient(logger: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(logger)
            .build()

    @Provides
    @Singleton
    fun provideGson(): Converter.Factory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(client:OkHttpClient,gson:Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gson)
            .client(client)
            .build()
}