package com.apa.accenture.myandroidstudioapp.data

import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.data.network.SuperheroApiService
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroDetailsModel
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroModel
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import com.apa.accenture.myandroidstudioapp.domain.model.SuperheroDetails
import com.apa.accenture.myandroidstudioapp.domain.model.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val apiService: SuperheroApiService,
    private val favSuperheroDAO: FavSuperheroDAO,

    ) {
    suspend fun getSuperheroFromApi(name:String): List<Superhero>{
        val response: SuperheroModel? = apiService.getSuperheroes(name)
        val listResponse: List<SuperheroResponse> = response!!.superheroes
        return listResponse.map { it.toDomain() }
    }

//    suspend fun getSuperheroByPublisherFromApi(name:String): List<Superhero>{
//        val response: SuperheroModel? = apiService.getSuperheroesByPublisher(name)
//        val listResponse: List<SuperheroResponse> = response!!.superheroes
//        return listResponse.map { it.toDomain() }
//    }

    //poner fromdatabase

    suspend fun getSuperheroDetailsFromApi(id: String): SuperheroDetails?{
        val response: SuperheroDetailsModel? = apiService.getSuperheroesDetails(id)
        return response?.toDomain()
    }

    suspend fun insertFavoriteSuperhero(fav: FavSuperheroEntity) {
        favSuperheroDAO.insertFavoriteSuperhero(fav)
    }

    suspend fun deleteFavoriteSuperhero(fav: FavSuperheroEntity){
       favSuperheroDAO.deleteFavoriteSuperhero(fav)
    }

    suspend fun getFavoriteSuperheroIds():List<Superhero> {
        val response = favSuperheroDAO.getFavoriteSuperheroIds()
        return response.map { it.toDomain() }
    }

    suspend fun getFavoriteSuperheroById(superheroId:String):FavSuperheroEntity?{
        return favSuperheroDAO.getFavoriteSuperheroById(superheroId)
    }

    suspend fun isFav(superheroId:String):Boolean{
        return favSuperheroDAO.isFav(superheroId)
    }

}