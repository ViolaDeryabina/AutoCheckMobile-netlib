package com.example.netlib.data.di.network

import com.example.netlib.data.service.AssignmentsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// Назначение: Модуль для предоставления AssignmentsService (CRUD операций с тестовыми заданиями)
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
object AssignmentsNetworkModule {

    @Provides
    @Singleton
    fun provideAssignmentsService(retrofit: Retrofit): AssignmentsService =
        retrofit.create(AssignmentsService::class.java)
}