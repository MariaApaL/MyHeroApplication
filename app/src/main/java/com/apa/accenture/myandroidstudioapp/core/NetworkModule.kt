package com.apa.accenture.myandroidstudioapp.core

import com.apa.accenture.myandroidstudioapp.data.network.SuperheroApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Para injectar librerias ( ejemplo retrofit), ya que no podemos acceder a ella por dagger
@Module
//Para que cualquier clase pueda acceder a el
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideSuperHeroApi(retrofit: Retrofit): SuperheroApi {
        return retrofit.create(SuperheroApi::class.java)

    }


}