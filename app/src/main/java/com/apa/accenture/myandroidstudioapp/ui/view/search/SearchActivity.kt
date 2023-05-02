package com.apa.accenture.myandroidstudioapp.ui.view.search

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.apa.accenture.myandroidstudioapp.di.NetworkModule
import com.apa.accenture.myandroidstudioapp.databinding.ActivitySearchBinding
import com.apa.accenture.myandroidstudioapp.ui.view.details.DetailsActivity
import com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder.SuperheroAdapter
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroModel
import com.apa.accenture.myandroidstudioapp.databinding.BottomLayoutBinding
import com.apa.accenture.myandroidstudioapp.databinding.SuperheroItemBinding
import com.apa.accenture.myandroidstudioapp.ui.view.MainActivity
import com.apa.accenture.myandroidstudioapp.ui.view.details.DetailsActivity.Companion.EXTRA_ID
import com.apa.accenture.myandroidstudioapp.ui.view.favourites.FavActivity
import com.apa.accenture.myandroidstudioapp.ui.view.favourites.FavActivity.Companion.FAV_ID
import com.apa.accenture.myandroidstudioapp.ui.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity @Inject constructor(): AppCompatActivity() {



//    private lateinit var bottomLayoutBinding: BottomLayoutBinding
    private lateinit var binding: ActivitySearchBinding

    private var retrofit:Retrofit = NetworkModule.provideRetrofit()
    private  var retrofitApi = NetworkModule.provideSuperHeroApi(retrofit)
    private val superheroViewModel: SearchViewModel by viewModels()
    private lateinit var adapter:SuperheroAdapter
    private var selectedSuperheroId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Conectamos la Activity con su layout
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        superheroViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
            binding.rvSuperhero.isVisible = !it
        })
        searchSuperhero("a")

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




        initUI()
    }

    private fun initUI(){

        adapter = SuperheroAdapter(
            onFavSelected = { superheroId ->
                adapter.addFavorite(superheroId)

            },
            onItemSelected = { superheroId ->
                navigateToDetail(superheroId)
            },
            superheroViewModel = superheroViewModel,

        )
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                superheroViewModel.searchSuperhero(query.orEmpty())
                searchSuperhero(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })



    }


    private fun searchSuperhero(query: String) {

        binding.progressBar.isVisible = true;
        //corrutinas
        //SI queremos que ejecute en unhilo secundario (peticiones,guardar en bbdd, procesos muy largos..) se usa IO)
        CoroutineScope(Dispatchers.IO).launch {

            val myResponse: Response<SuperheroModel> = retrofitApi.getSuperheroes(query)
            if(myResponse.isSuccessful) {
                val response: SuperheroModel? = myResponse.body()

                if(response!= null){
                    Log.i("maria",response.toString())
                    //Ejecutar en el hilo principal (el UI siempre en el hilo principal)
                    runOnUiThread{
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible = false
                    }
                }
            }else{
                Log.i("maria"," no funciona")
            }
        }
    }





    private fun navigateToDetail(id:String){

        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        println(id)
        startActivity(intent)
    }


//    private fun navigateToFav(id:String){
//
//        val intent = Intent(this, FavActivity::class.java)
//        intent.putExtra(FAV_ID,id)
//        println(id)
//        startActivity(intent)
//    }




}