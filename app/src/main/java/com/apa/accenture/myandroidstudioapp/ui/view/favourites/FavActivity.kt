package com.apa.accenture.myandroidstudioapp.ui.view.favourites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apa.accenture.myandroidstudioapp.R
import com.apa.accenture.myandroidstudioapp.data.SuperheroRepository
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroResponse
import com.apa.accenture.myandroidstudioapp.databinding.ActivityFavBinding
import com.apa.accenture.myandroidstudioapp.databinding.BottomLayoutBinding
import com.apa.accenture.myandroidstudioapp.ui.view.MainActivity
import com.apa.accenture.myandroidstudioapp.ui.view.details.DetailsActivity
import com.apa.accenture.myandroidstudioapp.ui.view.favourites.adapterviewholder.FavAdapter
import com.apa.accenture.myandroidstudioapp.ui.view.search.SearchActivity
import com.apa.accenture.myandroidstudioapp.ui.viewmodel.SearchViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavBinding
    private lateinit var bottomLayoutBinding: BottomLayoutBinding

    private val superheroViewModel: SearchViewModel by viewModels()
    private lateinit var adapter: FavAdapter





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()

    }

    fun initUi(){
        adapter = FavAdapter(emptyList())
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter

        superheroViewModel.favList.observe(this, Observer{it->
            Log.v("LISTA",it.toString())
            adapter.updateList(it)

        }
        )

    }



    }
