package com.apa.accenture.myandroidstudioapp.ui.view.search

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.apa.accenture.myandroidstudioapp.core.NetworkModule
import com.apa.accenture.myandroidstudioapp.data.network.SuperheroApi
import com.apa.accenture.myandroidstudioapp.databinding.ActivitySearchBinding
import com.apa.accenture.myandroidstudioapp.ui.view.details.DetailsActivity
import com.apa.accenture.myandroidstudioapp.ui.view.search.adapterviewholder.SuperheroAdapter
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroModel
import com.apa.accenture.myandroidstudioapp.ui.view.details.DetailsActivity.Companion.EXTRA_ID
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity @Inject constructor(): AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    //    private val superheroViewModel: SuperheroViewModel by viewModels()
    private lateinit var adapter:SuperheroAdapter
    private lateinit var retrofit:Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Conectamos la Activity con su layout
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = NetworkModule.provideRetrofit()


        initUI()
    }

    private fun initUI(){


        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchSuperheroByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adapter = SuperheroAdapter{ superheroId -> navigateToDetail(superheroId)}
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun searchSuperheroByName(query: String) {

        binding.progressBar.isVisible = true;
        //corrutinas
        //SI queremos que ejecute en unhilo secundario (peticiones,guardar en bbdd, procesos muy largos..) se usa IO)
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitApi = NetworkModule.provideSuperHeroApi(retrofit)
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

    private fun searchSuperheroByPublisher(query: String){
        binding.progressBar.isVisible = true;
        //corrutinas
        //SI queremos que ejecute en unhilo secundario (peticiones,guardar en bbdd, procesos muy largos..) se usa IO)
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitApi = NetworkModule.provideSuperHeroApi(retrofit)
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


}