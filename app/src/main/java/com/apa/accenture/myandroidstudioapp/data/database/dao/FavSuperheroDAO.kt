package com.apa.accenture.myandroidstudioapp.data.database.dao

import androidx.room.*
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.domain.model.SuperheroDetails

//
//Añadir las sentencias para recoger datos
@Dao
interface  FavSuperheroDAO{

    //Inserta un superheroe
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertFavoriteSuperhero(favoriteSuperhero: FavSuperheroEntity)
    //Borra al superheroe
    @Delete
     fun deleteFavoriteSuperhero(favoriteSuperhero: FavSuperheroEntity)
    //Enlista los superheroes por id
    @Query("SELECT * FROM favorite_superhero")
    fun getFavoriteSuperheroIds(): List<String>

    @Query("SELECT * FROM favorite_superhero WHERE superheroId = :superheroId")
    fun getFavoriteSuperheroById(superheroId: String): FavSuperheroEntity?

}
