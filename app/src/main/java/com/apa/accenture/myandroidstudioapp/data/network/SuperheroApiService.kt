package com.apa.accenture.myandroidstudioapp.data.network

import com.apa.accenture.myandroidstudioapp.data.network.SuperheroApi
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroDetailsModel
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class SuperheroApiService @Inject constructor(private val superheroApi:SuperheroApi) {

    suspend fun getSuperheroes(name: String): SuperheroModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<SuperheroModel> = superheroApi.getSuperheroes(name)
            response.body() ?: SuperheroModel(emptyList())
        }
    }

    suspend fun getSuperheroesDetails(name: String): SuperheroDetailsModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<SuperheroDetailsModel> = superheroApi.getSuperheroesDetails(name)
            response.body()
        }
    }

//    suspend fun getSuperheroesByPublisher(id: String): SuperheroModel? {
//        return withContext(Dispatchers.IO) {
//            val response: Response<SuperheroModel> = superheroApi.getSuperheroesByPublisher(id)
//            response.body() ?: SuperheroModel(emptyList())
//        }
//    }
}

