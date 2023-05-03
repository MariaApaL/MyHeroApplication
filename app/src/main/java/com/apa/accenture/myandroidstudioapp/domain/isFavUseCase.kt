package com.apa.accenture.myandroidstudioapp.domain

import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import javax.inject.Inject

class isFavUseCase @Inject constructor(private val repository: SuperheroRepository) {

    suspend operator fun invoke(superheroId:String):Boolean{
        return repository.isFav(superheroId)

    }
}