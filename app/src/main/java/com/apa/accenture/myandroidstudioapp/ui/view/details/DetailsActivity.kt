package com.apa.accenture.myandroidstudioapp.ui.view.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.apa.accenture.myandroidstudioapp.di.NetworkModule
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroDetailsModel
import com.apa.accenture.myandroidstudioapp.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    private val retrofit = NetworkModule.provideRetrofit()
    private val retrofitApi = NetworkModule.provideSuperHeroApi(retrofit)
    companion object {
        const val EXTRA_ID = "extra_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)

    }



    private fun getSuperheroInformation(id: String) {
        binding.progressBar.isVisible = true;
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail: Response<SuperheroDetailsModel> =
                retrofitApi.getSuperheroesDetails(id)
            Log.i("id", superheroDetail.toString())

            if(superheroDetail.isSuccessful){
                val response:SuperheroDetailsModel? = superheroDetail.body()

                if (response != null) {
                    Log.i("maria",response.toString())
                    runOnUiThread {
                        createdUI(response!!)
                        binding.progressBar.isVisible = false
                    }


                }


            }
        }
    }

    private fun createdUI(superhero: SuperheroDetailsModel) {

        val string = "Unknow"
        Picasso.get().load(superhero.image.url).into(binding.ivDetailSuperhero)


        binding.tvHeroName.text = superhero.name
        if(superhero.biography.fullName.isBlank()||superhero.biography.fullName.isEmpty()|| superhero.biography.fullName == "null"){
            binding.tvRealName.text = string
        }
        binding.tvRealName.text = superhero.biography.fullName

        binding.tvAppear.text = superhero.biography.firstAppear
        binding.tvOccupation.text = superhero.work.occupation
        if(superhero.appearance.gender.isBlank()||superhero.appearance.gender.isEmpty()|| superhero.appearance.gender == "null"){
            binding.tvGender.text = string
        }
        binding.tvGender.text = superhero.appearance.gender
        if(superhero.appearance.race.isBlank()||superhero.appearance.race.isEmpty()|| superhero.appearance.race == "null"){
            binding.tvRace.text  = string
        }
        binding.tvRace.text = superhero.appearance.race
        binding.tvPublisher.text = superhero.biography.publisher
        binding.tvPower.text = superhero.powerstats.power
        binding.tvSpeed.text = superhero.powerstats.speed
        binding.tvStrenght.text = superhero.powerstats.strength

    }



}