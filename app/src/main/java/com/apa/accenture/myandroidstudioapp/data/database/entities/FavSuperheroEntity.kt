package com.apa.accenture.myandroidstudioapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "favourite_superhero")
data class FavSuperheroEntity (
    @PrimaryKey
    @ColumnInfo(name = "superheroId") val id: String
)
