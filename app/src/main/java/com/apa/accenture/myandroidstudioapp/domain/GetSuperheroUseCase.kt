package com.apa.accenture.myandroidstudioapp.domain

import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import javax.inject.Inject

class GetSuperheroUseCase @Inject constructor(private val repository: SuperheroRepository)  {

    suspend operator fun invoke(name: String): List<Superhero> {
        return repository.getSuperheroFromApi(name)
    }

}