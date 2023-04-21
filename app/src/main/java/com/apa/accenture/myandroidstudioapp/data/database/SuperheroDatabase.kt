package com.apa.accenture.myandroidstudioapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity

@Database(entities = [FavSuperheroEntity::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase(){

    abstract fun getFavSuperheroDAO(): FavSuperheroDAO
}