package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels

import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.ui.viewmodel.SearchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SuperheroAdapter @Inject constructor( private val onFavSelected: (String)->Unit ,
                                           var superheroList: List<SuperheroResponse> = emptyList(),
                                           private val onItemSelected: (String) -> Unit,
                                            private val superheroViewModel: SearchViewModel,
)
    : RecyclerView.Adapter<SuperheroViewHolder>() {
//
//    private var favDao: FavSuperheroDAO

//    para actualizar la lista de datos que se
//    muestra en el RecyclerView y refrescar la vista para mostrar los cambios.
   private var favoriteIds: MutableList<String> = mutableListOf()


//    private fun onFavItemSelected(superheroId: String) {
//        onNavigateToFav(superheroId)
//        onFavSelected(superheroId)
//    }


    fun updateList(list: List<SuperheroResponse>){
        this.superheroList = list

        notifyDataSetChanged()
    }

    fun addFavorite(id: String) {
        if (!favoriteIds.contains(id)) {
            favoriteIds.add(id)
            superheroViewModel.updateFavoriteIds(favoriteIds)
            notifyDataSetChanged()
        }
    }

// se encarga de crear una nueva instancia del ViewHolder que se usará para mostrar
// un elemento de la lista en la pantalla. Recibe como parámetros el ViewGroup padre y un viewType que
// indica el tipo de vista que se debe crear (en caso de que haya diferentes tipos de vistas en la lista).

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val binding = SuperheroItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SuperheroViewHolder(binding)
    }

//    Devuelve el número de elementos en la lista que se va a mostrar en el RecyclerView.
//    Este número se utiliza para determinar cuántas veces se llamará al método onBindViewHolder().

    override fun getItemCount(): Int {
        return superheroList.size
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        var superhero = superheroList[position]
        viewholder.bind(superhero,onItemSelected, onFavSelected, favoriteIds)

        viewholder.binding.tbFav.setOnClickListener {
            val isFavorite = favoriteIds.contains(superhero.superheroId)
            if (isFavorite) {
                favoriteIds.remove(superhero.superheroId)
            } else {
                favoriteIds.add(superhero.superheroId)
            }
            viewholder.binding.tbFav.isChecked = !isFavorite
            superheroViewModel.updateFavoriteIds(favoriteIds)

        }

        }

    }

