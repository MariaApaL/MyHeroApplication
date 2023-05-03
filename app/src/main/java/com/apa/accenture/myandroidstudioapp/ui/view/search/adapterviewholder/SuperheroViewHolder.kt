package com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder

import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.R
import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
//import com.apa.accenture.myandroidstudioapp.data.database.SuperheroDatabase
//import com.apa.accenture.myandroidstudioapp.data.database.entities.FavSuperheroEntity
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


import kotlinx.coroutines.launch
import javax.inject.Inject

import kotlin.reflect.KSuspendFunction1

class SuperheroViewHolder@Inject constructor( val binding: SuperheroItemBinding) :
    RecyclerView.ViewHolder(binding.root){



    fun bind(
        superheroResponse: SuperheroResponse,
        onItemSelected: (String)-> Unit,
        isFav: KSuspendFunction1<String, Boolean>,
        insertFav:KSuspendFunction1<FavSuperheroEntity, Unit>,
        deleteFavorite:KSuspendFunction1<FavSuperheroEntity, Unit>

    ){
        binding.tvSuperheroName.text=superheroResponse.name
        binding.tvPublisherName.text=superheroResponse.biography.publisher

//        CoroutineScope(Dispatchers.IO).launch {
//
//            if(isFav(superheroResponse.superheroId))    {
//                binding.tbFav.isChecked = true
//
//                binding.tbFav.setBackgroundResource(R.drawable.fav_icon_heart_red)
//            }else{
//                binding.tbFav.isChecked = false
//                binding.tbFav.setBackgroundResource(R.drawable.fav_icon_heart_gray)
//            }
//            }



        binding.tbFav.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                if(isFav(superheroResponse.superheroId)){
//                    binding.tbFav.setBackgroundResource(R.drawable.fav_icon_heart_gray)
                    deleteFavorite(FavSuperheroEntity(superheroResponse.superheroId,
                        superheroResponse.name,superheroResponse.biography, superheroResponse.superheroImage,
                    ))
                }else{
//                    binding.tbFav.setBackgroundResource(R.drawable.fav_icon_heart_red)
                    insertFav(FavSuperheroEntity(superheroResponse.superheroId,
                        superheroResponse.name,superheroResponse.biography, superheroResponse.superheroImage,
                    ))
                }
            }

        }


//        binding.tbFav.apply {
//
//                isChecked = isFav(superheroResponse.superheroId)
//
//                background = ContextCompat.getDrawable(
//                    binding.tbFav.context,
//                    if (isChecked) R.drawable.fav_icon_heart_red else R.drawable.fav_icon_heart_gray
//                )
//                setOnCheckedChangeListener { _, isChecked ->
//                    background = ContextCompat.getDrawable(
//                        binding.tbFav.context,
//                        if (isChecked) R.drawable.fav_icon_heart_red else R.drawable.fav_icon_heart_gray
//                    )
//
//                }
//
//        }
        Picasso.get().load(superheroResponse.superheroImage.url).into(binding.ivSuperhero)
        //root es el item. Por lo tanto, donde sea que se pulse detro del item recogera el id
        binding.root.setOnClickListener { onItemSelected(superheroResponse.superheroId) }

    }

}