package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.R
import com.apa.accenture.myandroidstudioapp.data.database.SuperheroDatabase
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.di.RoomModule
import com.squareup.picasso.Picasso

class SuperheroViewHolder(private val binding: SuperheroItemBinding) :
    RecyclerView.ViewHolder(binding.root){
    private lateinit var

    //    establecer el contenido
//    de las vistas de un elemento de la lista
//    con los datos de un objeto SuperheroResponse
    fun bind(superheroResponse: SuperheroResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperheroName.text=superheroResponse.name
        binding.tvPublisherName.text=superheroResponse.biography.publisher

        binding.tbFav.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val favoriteSuperhero = FavSuperheroEntity(superheroResponse.superheroId)
                db.favoriteSuperheroDao().insertFavoriteSuperhero(favoriteSuperhero)
                Toast.makeText(this, "Superhero added to favorites!", Toast.LENGTH_SHORT).show()
            } else {
                val favoriteSuperhero = FavoriteSuperhero(superhero.id)
                db.favoriteSuperheroDao().deleteFavoriteSuperhero(favoriteSuperhero)
                Toast.makeText(this, "Superhero removed from favorites!", Toast.LENGTH_SHORT).show()
            }
        }
//        binding.tbFav.apply {
//            isChecked = false
//            background = ContextCompat.getDrawable( binding.tbFav.context, R.drawable.fav_icon_heart_gray)
//            setOnCheckedChangeListener { _, isChecked ->
//                background = if (isChecked) {
//                    ContextCompat.getDrawable(binding.tbFav.context, R.drawable.fav_icon_heart_red)
//                } else {
//                    ContextCompat.getDrawable(binding.tbFav.context, R.drawable.fav_icon_heart_gray)
//                }
//            }
//        }
        Picasso.get().load(superheroResponse.superheroImage.url).into(binding.ivSuperhero)
        //root es el item. Por lo tanto, donde sea que se pulse detro del item recogera el id
        binding.root.setOnClickListener { onItemSelected(superheroResponse.superheroId) }

    }

}