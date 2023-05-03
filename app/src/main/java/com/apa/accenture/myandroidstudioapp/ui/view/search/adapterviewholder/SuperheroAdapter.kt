package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import javax.inject.Inject
import kotlin.reflect.KSuspendFunction1

class SuperheroAdapter @Inject constructor(
                                           var superheroList: List<SuperheroResponse> = emptyList(),
                                           private val onItemSelected: (String) -> Unit,
                                           private val isFav: KSuspendFunction1<String, Boolean>,
                                           private val insertFav:KSuspendFunction1<FavSuperheroEntity, Unit>,
                                           private val deleteFavorite:KSuspendFunction1<FavSuperheroEntity, Unit>,

                                           )
    : RecyclerView.Adapter<SuperheroViewHolder>() {




    fun updateList(list: List<SuperheroResponse>){
        this.superheroList = list

        notifyDataSetChanged()
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
        viewholder.bind(superhero,onItemSelected, isFav ,insertFav, deleteFavorite)



        }

        }



