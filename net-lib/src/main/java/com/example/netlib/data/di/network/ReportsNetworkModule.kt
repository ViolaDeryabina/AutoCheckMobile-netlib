package com.example.netlib.data.di.network

import com.example.netlib.data.service.ReportsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// Назначение: Модуль для предоставления ReportsService (статистика проверок и health check)
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
object ReportsNetworkModule {

    @Provides
    @Singleton
    fun provideReportsService(retrofit: Retrofit): ReportsService =
        retrofit.create(ReportsService::class.java)
}