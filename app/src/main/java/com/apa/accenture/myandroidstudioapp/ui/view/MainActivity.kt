package com.apa.accenture.myandroidstudioapp.ui.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.apa.accenture.myandroidstudioapp.R
import com.apa.accenture.myandroidstudioapp.databinding.ActivityMainBinding
import com.apa.accenture.myandroidstudioapp.databinding.BottomLayoutBinding
import com.apa.accenture.myandroidstudioapp.ui.view.favourites.FavActivity

import com.apa.accenture.myandroidstudioapp.ui.view.search.SearchActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomLayoutBinding: BottomLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Conectamos la Activity con su layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Inicializamos el boton Start para navegar al Menu
        binding.btnSearch.setOnClickListener { navigateToSearch() }
        binding.btnFav.setOnClickListener { navigateToFav() }
//        bottomLayoutBinding = BottomLayoutBinding.inflate(layoutInflater)
//
//        bottomLayoutBinding.navigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.home -> {
//                    return@setOnItemSelectedListener true
//                }
//                R.id.search -> {
//
//                    val intent = Intent(this, SearchActivity::class.java)
//                    startActivity(intent)
//                    return@setOnItemSelectedListener true
//                }
//                R.id.fav -> {
//                    val intent = Intent(this, FavActivity::class.java)
//                    startActivity(intent)
//                    return@setOnItemSelectedListener true
//                }
//                else ->  return@setOnItemSelectedListener false
//            }
//        }
//
//    }
    }

    private fun navigateToFav() {
        val intent = Intent(this, FavActivity::class.java)
        startActivity(intent)
    }


    //Navegamos al menu
    private fun navigateToSearch() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }


}