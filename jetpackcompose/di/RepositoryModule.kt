package com.example.jetpackcompose.di

import com.example.jetpackcompose.data.repository_data.ProductRepositoryImplData
import com.example.jetpackcompose.domain.repositoryDomain.ProductRepositoryDomain
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract  class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(impl : ProductRepositoryImplData) : ProductRepositoryDomain
}