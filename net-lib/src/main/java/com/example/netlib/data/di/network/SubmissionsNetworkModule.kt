package com.example.netlib.data.di.network

import com.example.netlib.data.service.SubmissionsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// Назначение: Модуль для предоставления SubmissionsService (загрузка решений, статусы, результаты, вердикты)
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
object SubmissionsNetworkModule {

    @Provides
    @Singleton
    fun provideSubmissionsService(retrofit: Retrofit): SubmissionsService =
        retrofit.create(SubmissionsService::class.java)
}