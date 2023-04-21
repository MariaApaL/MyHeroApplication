package com.apa.accenture.myandroidstudioapp.ui.view.favourites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apa.accenture.myandroidstudioapp.databinding.ActivityFavBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}