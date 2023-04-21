package com.apa.accenture.myandroidstudioapp.data.network.model

import com.google.gson.annotations.SerializedName

data class SuperheroDetailsModel(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("biography") val biography:Biography,
    @SerializedName("appearance") val appearance:Appearance,
    @SerializedName("work") val work:Work,
    @SerializedName("image") val image: SuperheroImgResponse,
)

data class PowerStats(

    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,

    @SerializedName("power") val power: String,


)

data class SuperheroImgResponse(
    @SerializedName("url") val url:String)

data class Biography(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("publisher") val publisher:String,
    @SerializedName("first-appearance") val firstAppear:String,

)

data class Appearance(
    @SerializedName("gender") val gender:String,
    @SerializedName("race") val race:String,
)

data class Work(
    @SerializedName("occupation") val occupation:String,
    )