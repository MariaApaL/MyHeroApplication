package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse

class SuperheroAdapter(var superheroList: List<SuperheroResponse> = emptyList(),
                       private val onItemSelected: (String) -> Unit
): RecyclerView.Adapter<SuperheroViewHolder>() {

//    para actualizar la lista de datos que se
//    muestra en el RecyclerView y refrescar la vista para mostrar los cambios.

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
        viewholder.bind(superheroList[position],onItemSelected)

    }

}