package com.apa.accenture.myandroidstudioapp.domain

import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import com.apa.accenture.myandroidstudioapp.domain.model.SuperheroDetails
import javax.inject.Inject

class GetSuperheroDetailsUseCase @Inject constructor(private val repository: SuperheroRepository)  {

    suspend operator fun invoke(id: String): SuperheroDetails? {
        return repository.getSuperheroDetailsFromApi(id)
    }

}