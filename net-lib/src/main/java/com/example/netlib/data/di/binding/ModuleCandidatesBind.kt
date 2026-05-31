package com.example.netlib.data.di.binding

import com.example.netlib.data.repositoryImpl.CandidatesRepositoryImpl
import com.example.netlib.domain.repository.CandidatesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Назначение: Создание связи между репозиторием и реализацией для работы с кандидатами
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleCandidatesBind {

    @Binds
    @Singleton
    abstract fun candidatesBind(candidatesRepositoryImpl: CandidatesRepositoryImpl): CandidatesRepository
}