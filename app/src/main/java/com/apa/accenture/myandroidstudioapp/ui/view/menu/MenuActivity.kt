package com.apa.accenture.myandroidstudioapp.ui.view.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apa.accenture.myandroidstudioapp.databinding.ActivityMenuBinding
import com.apa.accenture.myandroidstudioapp.ui.view.favourites.FavActivity
import com.apa.accenture.myandroidstudioapp.ui.view.search.SearchActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Boton para navegar a la vista de favoritos
        binding.btnFav.setOnClickListener { navigateToFavActivity() }
        //Boton para navegar a la vista del buscador
        binding.btnSearch.setOnClickListener { navigateToSearchActivity() }
    }

    private fun navigateToFavActivity() {
        val intent = Intent(this, FavActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSearchActivity() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
}