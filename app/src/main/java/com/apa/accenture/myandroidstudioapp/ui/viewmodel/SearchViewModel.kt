package com.apa.accenture.myandroidstudioapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.domain.*
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(


    private val isFavUseCase: isFavUseCase,
    private val getSuperheroFavUseCase: GetSuperheroFavUseCase,

    private val deleteFav:DeleteSuperheroFav,
    private val insertSuperhero: InsertSuperheroFavUseCase,
    private val superheroRepository: SuperheroRepository,


) : ViewModel() {

        var favList = MutableLiveData<List<Superhero>>()
        val isLoading= MutableLiveData<Boolean>()

    suspend fun isFav(superheroId: String):Boolean{

      return  isFavUseCase(superheroId)
    }

   suspend fun insertFav(favSuperhero: FavSuperheroEntity){
        insertSuperhero(favSuperhero)
    }

    suspend fun deleteFavorite(favSuperhero: FavSuperheroEntity){
        deleteFav(favSuperhero)
    }

    fun getFav(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val list = getSuperheroFavUseCase()
            favList.postValue(list)

            isLoading.postValue(false)
        }

    }



}










