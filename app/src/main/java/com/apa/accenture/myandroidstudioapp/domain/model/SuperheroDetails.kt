package com.apa.accenture.myandroidstudioapp.domain.model

import com.apa.accenture.myandroidstudioapp.data.network.model.*

import com.google.gson.annotations.SerializedName

data class SuperheroDetails(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String,
    @SerializedName("powerstats") val powerstats:PowerStats,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("appearance") val appearance: Appearance,
    @SerializedName("work") val work: Work,
    @SerializedName("image") val image: SuperheroImgResponse,
)


fun SuperheroDetailsModel.toDomain() =
    SuperheroDetails(name, id,powerstats, biography, appearance, work, image)
