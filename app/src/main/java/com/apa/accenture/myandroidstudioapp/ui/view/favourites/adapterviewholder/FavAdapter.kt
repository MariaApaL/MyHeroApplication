package com.apa.accenture.myandroidstudioapp.ui.view.favourites.adapterviewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.databinding.FavHeroItemBinding
import com.apa.accenture.myandroidstudioapp.domain.model.Superhero


class FavAdapter(var superheroFavList: List<Superhero> = emptyList()): RecyclerView.Adapter<FavViewHolder>() {

    fun updateList(list: List<Superhero>){
        this.superheroFavList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val binding = FavHeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavViewHolder(binding)
    }

    override fun getItemCount(): Int = superheroFavList.size

    override fun onBindViewHolder(viewholder: FavViewHolder, position: Int) {
        val superheroId = superheroFavList[position]

        viewholder.bind(superheroId)
    }
}

