package com.example.netlib.data.di.network

import com.example.netlib.data.service.AuthenticationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// Назначение: Модуль для предоставления AuthenticationService
// Автор: Дерябина В.Н.
// Дата создания 18-05-2026
@Module
@InstallIn(SingletonComponent::class)
object AuthNetworkModule {
    @Provides
    @Singleton
    fun provideAuth(retrofit: Retrofit): AuthenticationService =
        retrofit.create(AuthenticationService::class.java)
}