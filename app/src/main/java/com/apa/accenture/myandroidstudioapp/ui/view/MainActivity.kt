package com.apa.accenture.myandroidstudioapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apa.accenture.myandroidstudioapp.databinding.ActivityMainBinding

import com.apa.accenture.myandroidstudioapp.ui.view.menu.MenuActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Conectamos la Activity con su layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Inicializamos el boton Start para navegar al Menu
        binding.btnStart.setOnClickListener { navigateToMenu() }

    }

    //Navegamos al menu
    private fun navigateToMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}