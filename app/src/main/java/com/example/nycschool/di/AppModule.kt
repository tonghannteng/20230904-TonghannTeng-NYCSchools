package com.example.nycschool.di

import com.example.nycschool.service.ISchoolService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author: Tonghann Teng
 * @since: 9/4/2023
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): ISchoolService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ISchoolService::class.java)


    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/"
    }
}