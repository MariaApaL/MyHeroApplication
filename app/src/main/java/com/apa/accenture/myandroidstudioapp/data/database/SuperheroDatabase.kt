package com.apa.accenture.myandroidstudioapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.Converters
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity

@Database(entities = [FavSuperheroEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class SuperheroDatabase : RoomDatabase(){

    abstract fun getFavSuperheroDAO(): FavSuperheroDAO
}

