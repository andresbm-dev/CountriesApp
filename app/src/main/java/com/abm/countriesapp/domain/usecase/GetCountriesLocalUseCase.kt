package com.abm.countriesapp.domain.usecase

import com.abm.countriesapp.data.database.CountriesEntity

interface GetCountriesLocalUseCase {
    suspend operator fun invoke():List<CountriesEntity>
}