package com.apa.accenture.myandroidstudioapp.ui.view.favourites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apa.accenture.myandroidstudioapp.R
import com.apa.accenture.myandroidstudioapp.databinding.ActivityFavBinding
import com.apa.accenture.myandroidstudioapp.databinding.BottomLayoutBinding
import com.apa.accenture.myandroidstudioapp.ui.view.MainActivity
import com.apa.accenture.myandroidstudioapp.ui.view.details.DetailsActivity
import com.apa.accenture.myandroidstudioapp.ui.view.search.SearchActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavBinding
    private lateinit var bottomLayoutBinding: BottomLayoutBinding

    companion object {
        const val FAV_ID= "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String = intent.getStringExtra(FavActivity.FAV_ID).orEmpty()
//        bottomLayoutBinding = BottomLayoutBinding.inflate(layoutInflater)
//
//        bottomLayoutBinding.navigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.home -> {
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                    return@setOnItemSelectedListener true
//                }
//                R.id.search -> {
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
    }
    }
