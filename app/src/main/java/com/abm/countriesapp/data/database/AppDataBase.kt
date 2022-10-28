package com.abm.countriesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CountriesEntity::class] , version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getCountriesDao(): CountriesDao
}