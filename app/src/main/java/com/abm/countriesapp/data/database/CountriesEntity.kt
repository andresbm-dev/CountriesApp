package com.abm.countriesapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries_table")
data class CountriesEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var nameCountry : String? = null,
    var imageFlag : String? = null,
    var capital :String? = null
)

