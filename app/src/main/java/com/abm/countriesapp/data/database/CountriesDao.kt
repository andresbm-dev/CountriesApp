package com.abm.countriesapp.data.database

import androidx.room.*

@Dao
interface CountriesDao {
    @Query("SELECT * FROM countries_table")
    suspend fun getAllCatFav(): List<CountriesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFavorite(countries: CountriesEntity)

    @Delete()
    suspend fun deleteFavorite(countries: List<CountriesEntity>)

}
