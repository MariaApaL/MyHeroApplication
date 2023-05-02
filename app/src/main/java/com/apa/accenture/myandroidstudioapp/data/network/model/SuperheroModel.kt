package com.apa.accenture.myandroidstudioapp.data.network.model

import com.google.gson.annotations.SerializedName

data class SuperheroModel(

@SerializedName("results") val superheroes: List<SuperheroResponse>
)

data class SuperheroResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperheroImageResponse,
    @SerializedName("biography") val biography:Publisher
)

data class SuperheroImageResponse(
    @SerializedName("url") val url:String)

data class Publisher(
    @SerializedName("publisher") val publisher:String,
)