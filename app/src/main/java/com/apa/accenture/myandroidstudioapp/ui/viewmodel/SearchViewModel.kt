package com.apa.accenture.myandroidstudioapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.domain.DeleteSuperheroFav
import com.apa.accenture.myandroidstudioapp.domain.GetSuperHeroFavByIdUseCase
import com.apa.accenture.myandroidstudioapp.domain.InsertSuperheroFavUseCase
import com.apa.accenture.myandroidstudioapp.domain.GetSuperheroUseCase
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

    private val getSuperhero: GetSuperheroUseCase,
    private val getSuperheroFav: InsertSuperheroFavUseCase,
    private val getSuperHeroFavById: GetSuperHeroFavByIdUseCase,
    private val deleteFav: DeleteSuperheroFav,
    private val insertSuperhero: InsertSuperheroFavUseCase,
    private val superheroRepository: SuperheroRepository,
    private val favDao: FavSuperheroDAO

) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val superheroModel: List<Superhero> = emptyList()
    val responseLiveData = MutableLiveData<List<Superhero>>()
    private val favoriteIdsList = MutableLiveData<List<String>>()


    fun getFavoriteIds(): LiveData<List<String>> {
        return favoriteIdsList
    }


    fun updateFavoriteIds(ids: List<String>) {
        favoriteIdsList.value = ids
    }

//    fun searchSuperhero(query: String) {
//        isLoading.postValue(true)
//        viewModelScope.launch {
//            val result = getSuperhero(query)
//            if(result.isEmpty()){
//                responseLiveData.postValue(emptyList())
//            }
//            responseLiveData.postValue(result)
//            isLoading.postValue(false)
//        }
//    }





}










