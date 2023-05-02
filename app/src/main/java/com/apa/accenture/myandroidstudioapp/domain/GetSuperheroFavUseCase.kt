package com.apa.accenture.myandroidstudioapp.domain

import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import com.apa.accenture.myandroidstudioapp.domain.model.SuperheroDetails
import java.util.*

import javax.inject.Inject
import kotlin.collections.List

class GetSuperheroFavUseCase @Inject constructor(private val repository: SuperheroRepository) {

    suspend operator fun invoke(): List<String> {
        return repository.getFavoriteSuperheroIds()
    }

}