package com.abm.countriesapp.data.database

import androidx.room.*

@Dao
interface CountriesDao {
    @Query("SELECT * FROM countries_table")
    suspend fun getAllCountriesDao(): List<CountriesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: CountriesEntity)

}
