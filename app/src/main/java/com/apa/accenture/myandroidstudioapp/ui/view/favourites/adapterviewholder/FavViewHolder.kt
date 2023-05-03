package com.apa.accenture.myandroidstudioapp.ui.view.favourites.adapterviewholder

import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.databinding.FavHeroItemBinding
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero
import com.squareup.picasso.Picasso
import javax.inject.Inject

class FavViewHolder@Inject constructor(val binding: FavHeroItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(superhero: Superhero) {

        binding.tvSuperheroName.text=superhero.name
        binding.tvPublisherName.text=superhero.biography.publisher
        Picasso.get().load(superhero.superheroImage.url).into(binding.ivSuperhero)

    }
}