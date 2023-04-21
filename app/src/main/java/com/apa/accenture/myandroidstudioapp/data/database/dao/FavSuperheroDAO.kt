package com.apa.accenture.myandroidstudioapp.data.database.dao

import androidx.room.*
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity


//Añadir las sentencias para recoger datos
@Dao
interface  FavSuperheroDAO{

    //Inserta un superheroe
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteSuperhero(favoriteSuperhero: FavSuperheroEntity)
    //Borra al superheroe
    @Delete
    suspend fun deleteFavoriteSuperhero(favoriteSuperhero: FavSuperheroEntity)
    //Enlista los superheroes por id
    @Query("SELECT superheroId FROM favorite_superheroes")
    suspend fun getFavoriteSuperheroIds(): List<String>
}
