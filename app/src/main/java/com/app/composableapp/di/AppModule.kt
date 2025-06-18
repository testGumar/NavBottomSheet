package com.app.composableapp.di

import com.app.composableapp.data.remote.AppApi
import com.app.composableapp.presentation.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): AppApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AppApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideProductsRepo(): ProductRepo = ProductRepoImpl()
}