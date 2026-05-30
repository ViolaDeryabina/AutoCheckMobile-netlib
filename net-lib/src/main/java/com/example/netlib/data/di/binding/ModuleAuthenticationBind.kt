package com.example.netlib.data.di.binding

import com.example.netlib.data.repositoryImpl.AuthenticationRepositoryImpl
import com.example.netlib.domain.repository.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Назначение: Создание связи между репозиторием и реализацией для регистрации и авторизации
// Автор: Дерябина В.Н.
// Дата создания: 26-05-2026
@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleAuthenticationBind {

    @Binds
    @Singleton
    abstract fun authenticationBind(authenticationRepositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository
}