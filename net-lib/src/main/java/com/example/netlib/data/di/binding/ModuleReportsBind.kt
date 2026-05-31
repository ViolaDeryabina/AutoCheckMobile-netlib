package com.example.netlib.data.di.binding

import com.example.netlib.data.repositoryImpl.ReportsRepositoryImpl
import com.example.netlib.domain.repository.ReportsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Назначение: Создание связи между репозиторием и реализацией для работы с отчетами и статистикой
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleReportsBind {

    @Binds
    @Singleton
    abstract fun reportsBind(reportsRepositoryImpl: ReportsRepositoryImpl): ReportsRepository
}