package com.abm.countriesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abm.countriesapp.model.usecase.GetCountriesApiUseCase
import com.abm.countriesapp.model.usecase.GetCountriesApiUseCaseImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CountriesViewModelImp @Inject constructor(
private val getCountriesApiUseCase: GetCountriesApiUseCaseImp
): ViewModel(), CountriesViewModel {

    override fun getCountriesApi() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getCountriesApiUseCase.invoke()
            }
        }
    }


}