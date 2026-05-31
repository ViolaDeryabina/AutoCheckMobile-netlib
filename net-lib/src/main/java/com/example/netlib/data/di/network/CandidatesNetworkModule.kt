package com.example.netlib.data.di.network

import com.example.netlib.data.service.CandidatesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// Назначение: Модуль для предоставления CandidatesService (список кандидатов и детальная информация)
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
object CandidatesNetworkModule {

    @Provides
    @Singleton
    fun provideCandidatesService(retrofit: Retrofit): CandidatesService =
        retrofit.create(CandidatesService::class.java)
}