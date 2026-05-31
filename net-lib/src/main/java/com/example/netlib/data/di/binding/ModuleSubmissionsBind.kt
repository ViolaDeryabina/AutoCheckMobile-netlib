package com.example.netlib.data.di.binding

import com.example.netlib.data.repositoryImpl.SubmissionsRepositoryImpl
import com.example.netlib.domain.repository.SubmissionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Назначение: Создание связи между репозиторием и реализацией для управления проверками решений
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleSubmissionsBind {

    @Binds
    @Singleton
    abstract fun submissionsBind(submissionsRepositoryImpl: SubmissionsRepositoryImpl): SubmissionsRepository
}