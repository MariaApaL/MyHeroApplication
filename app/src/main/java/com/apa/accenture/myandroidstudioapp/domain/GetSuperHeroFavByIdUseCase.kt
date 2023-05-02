package com.apa.accenture.myandroidstudioapp.domain

import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import javax.inject.Inject



class GetSuperHeroFavByIdUseCase @Inject constructor(private val repository: SuperheroRepository) {

    suspend operator fun invoke(superheroId:String): FavSuperheroEntity?{
        return repository.getFavoriteSuperheroById(superheroId)
    }

}