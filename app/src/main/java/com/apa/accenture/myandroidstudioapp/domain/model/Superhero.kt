package com.apa.accenture.myandroidstudioapp.domain.model

import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.data.network.model.Publisher
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroImageResponse
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroModel
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.google.gson.annotations.SerializedName

data class Superhero(
   @SerializedName("id") val superheroId: String,
   @SerializedName("name") val name: String,
   @SerializedName("image") val superheroImage: SuperheroImageResponse,
   @SerializedName("biography") val biography: Publisher

)

fun SuperheroResponse.toDomain() =
   Superhero(superheroId= superheroId,
      name=name,superheroImage = superheroImage, biography= biography)

fun FavSuperheroEntity.toDomain() =
   Superhero(superheroId= id,
      name=name,superheroImage = superheroImage, biography= biography)