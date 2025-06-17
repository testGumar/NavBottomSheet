package com.app.composableapp.di

import com.app.composableapp.ui.feature.store.data.repo.ProductRepoImpl
import com.app.composableapp.ui.feature.store.domain.repo.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsProductsRepo(impl: ProductRepoImpl): ProductRepo
}