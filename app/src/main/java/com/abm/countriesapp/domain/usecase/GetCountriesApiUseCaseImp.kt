package com.abm.countriesapp.domain.usecase

import com.abm.countriesapp.data.network.repository.CountriesApiRepositoryImp
import com.abm.countriesapp.domain.model.Countries
import javax.inject.Inject

class GetCountriesApiUseCaseImp @Inject constructor(
private val repositoryImp: CountriesApiRepositoryImp
):GetCountriesApiUseCase {
    override suspend fun invoke():List<Countries> {
        return repositoryImp.getCountriesApi()
    }
}