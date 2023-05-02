package com.apa.accenture.myandroidstudioapp.data.network

import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroDetailsModel
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApi {

    @GET("/api/10231204575760255/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperheroModel>

//    @GET("/api/10231204575760255/{name}/biography/publisher")
//    suspend fun getSuperheroesByPublisher(@Path("name") superheroName:String): Response<SuperheroModel>

    @GET("/api/10231204575760255/{id}")
    suspend fun getSuperheroesDetails(@Path("id") superheroId:String): Response<SuperheroDetailsModel>
}