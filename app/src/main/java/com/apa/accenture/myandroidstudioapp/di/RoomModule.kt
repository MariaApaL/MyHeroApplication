package com.apa.accenture.myandroidstudioapp.di

import android.content.Context
import androidx.room.Room
import com.apa.accenture.myandroidstudioapp.data.database.SuperheroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {


    private const val SUPERHERO_DATABASE_NAME = "superhero_database"


    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        //context, clase donde está la bbddd y un nombre para la base de datos
        Room.databaseBuilder(context, SuperheroDatabase::class.java,SUPERHERO_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:SuperheroDatabase) = db.getFavSuperheroDAO()

}