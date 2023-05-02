package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.R
import com.apa.accenture.myandroidstudioapp.data.database.dao.FavSuperheroDAO
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
//import com.apa.accenture.myandroidstudioapp.data.database.SuperheroDatabase
//import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.ui.viewmodel.SearchViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject

class SuperheroViewHolder@Inject constructor( val binding: SuperheroItemBinding) :
    RecyclerView.ViewHolder(binding.root){


//    private val favDao: FavSuperheroDAO


    //    establecer el contenido
//    de las vistas de un elemento de la lista
//    con los datos de un objeto SuperheroResponse
    fun bind(
        superheroResponse: SuperheroResponse,
        onItemSelected: (String) -> Unit,
        onFavSelected: (String) -> Unit,
        favoriteIds: List<String>
//        viewModel: SearchViewModel
    ){
        binding.tvSuperheroName.text=superheroResponse.name
        binding.tvPublisherName.text=superheroResponse.biography.publisher

        binding.tbFav.apply {

                isChecked = favoriteIds.contains(superheroResponse.superheroId)
                background = ContextCompat.getDrawable(
                    binding.tbFav.context,
                    if (isChecked) R.drawable.fav_icon_heart_red else R.drawable.fav_icon_heart_gray
                )
                setOnCheckedChangeListener { _, isChecked ->
                    background = ContextCompat.getDrawable(
                        binding.tbFav.context,
                        if (isChecked) R.drawable.fav_icon_heart_red else R.drawable.fav_icon_heart_gray
                    )
                    onFavSelected(superheroResponse.superheroId)
                }

        }
        Picasso.get().load(superheroResponse.superheroImage.url).into(binding.ivSuperhero)
        //root es el item. Por lo tanto, donde sea que se pulse detro del item recogera el id
        binding.root.setOnClickListener { onItemSelected(superheroResponse.superheroId) }

    }

}