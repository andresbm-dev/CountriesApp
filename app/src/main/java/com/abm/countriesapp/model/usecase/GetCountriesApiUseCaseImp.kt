package com.abm.countriesapp.model.usecase

import com.abm.countriesapp.repository.CountriesApiRepositoryImp
import javax.inject.Inject

class GetCountriesApiUseCaseImp @Inject constructor(
private val repositoryImp: CountriesApiRepositoryImp
):GetCountriesApiUseCase {
    override suspend fun invoke() {
        repositoryImp.getCountriesApi()
    }
}