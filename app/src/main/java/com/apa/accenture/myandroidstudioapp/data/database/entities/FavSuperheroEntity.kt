package com.apa.accenture.myandroidstudioapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.apa.accenture.myandroidstudioapp.data.network.model.Biography
import com.apa.accenture.myandroidstudioapp.data.network.model.Publisher
import com.apa.accenture.myandroidstudioapp.data.network.model.SuperheroImageResponse


@Entity(tableName = "favorite_superhero")
data class FavSuperheroEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "superheroId") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name="biography")val biography: Publisher,
    @ColumnInfo(name="image") val superheroImage: SuperheroImageResponse
)
