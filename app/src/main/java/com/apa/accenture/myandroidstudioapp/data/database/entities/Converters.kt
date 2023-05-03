package com.apa.accenture.myandroidstudioapp.data.database.entities

import androidx.room.TypeConverter
import com.apa.accenture.myandroidstudioapp.data.network.model.Publisher
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroImageResponse

class Converters {

    @TypeConverter
    fun fromPublisher(publisher:Publisher):String{
        return publisher.publisher
    }

    @TypeConverter
    fun toPublisher(publisher:String):Publisher{

        return Publisher(publisher)
    }

    @TypeConverter
    fun fromSuperheroImage(superheroImageResponse: SuperheroImageResponse):String{
        return superheroImageResponse.url
    }

    @TypeConverter
    fun toSuperheroImage(superheroImageResponse:String):SuperheroImageResponse{
        return SuperheroImageResponse(superheroImageResponse)
    }
}