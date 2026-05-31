package com.example.netlib.data.di.binding

import com.example.netlib.data.repositoryImpl.AssignmentsRepositoryImpl
import com.example.netlib.domain.repository.AssignmentsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Назначение: Создание связи между репозиторием и реализацией для управления тестовыми заданиями
// Автор: Дерябина В.Н.
// Дата создания: 31-05-2026
@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleAssignmentsBind {

    @Binds
    @Singleton
    abstract fun assignmentsBind(assignmentsRepositoryImpl: AssignmentsRepositoryImpl): AssignmentsRepository
}