package com.abm.countriesapp.domain.usecase

import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.data.repository.CountriesApiRepositoryImp
import com.abm.countriesapp.data.repository.CountriesLocalRepositoryImp
import com.abm.countriesapp.domain.model.Countries
import javax.inject.Inject

class GetCountriesApiUseCaseImp @Inject constructor(
    private val repositoryImp: CountriesApiRepositoryImp,
    private val repositoryLocalImp:CountriesLocalRepositoryImp
) : GetCountriesApiUseCase {
    override suspend fun invoke(): List<Countries> {
        if (repositoryLocalImp.getAllCountriesDao().isEmpty()) {
            val result = repositoryImp.getCountriesApi()
            result.forEach { country->
                repositoryLocalImp.insertCountries(CountriesEntity(
                    nameCountry = country.nameCountry?.nameOfficial,
                    imageFlag = country.flag?.flagPng,
                    capital =  country.capital.toString()
                ))
            }
        }
        return repositoryImp.getCountriesApi()
    }
}