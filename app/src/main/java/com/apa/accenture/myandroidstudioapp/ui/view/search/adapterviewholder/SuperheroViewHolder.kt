package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.squareup.picasso.Picasso

class SuperheroViewHolder(private val binding: SuperheroItemBinding) :
    RecyclerView.ViewHolder(binding.root){

    //    establecer el contenido
//    de las vistas de un elemento de la lista
//    con los datos de un objeto SuperheroResponse
    fun bind(superheroResponse: SuperheroResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperheroName.text=superheroResponse.name
        binding.tvPublisherName.text=superheroResponse.biography.publisher
        Picasso.get().load(superheroResponse.superheroImage.url).into(binding.ivSuperhero)
        //root es el item. Por lo tanto, donde sea que se pulse detro del item recogera el id
        binding.root.setOnClickListener { onItemSelected(superheroResponse.superheroId) }

    }

}