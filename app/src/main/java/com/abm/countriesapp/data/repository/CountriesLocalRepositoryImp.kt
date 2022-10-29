package com.abm.countriesapp.data.repository

import com.abm.countriesapp.data.database.CountriesDao
import com.abm.countriesapp.data.database.CountriesEntity
import javax.inject.Inject

class CountriesLocalRepositoryImp @Inject constructor(
    private val countriesDao:CountriesDao
): CountriesLocalRepository {
    override suspend fun getAllCountriesDao(): List<CountriesEntity> {
        return try{
            countriesDao.getAllCountriesDao()
        }catch (e:Exception){
            emptyList()
        }
    }

    override suspend fun insertCountries(countries: CountriesEntity) {
        countriesDao.insertCountries(countries)
    }
}