package com.abm.countriesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abm.countriesapp.domain.model.Countries
import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCaseImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CountriesViewModelImp @Inject constructor(
private val getCountriesApiUseCase: GetCountriesApiUseCaseImp
): ViewModel(), CountriesViewModel {

    private val _countries : MutableLiveData<List<Countries>> = MutableLiveData()
    val countries : LiveData<List<Countries>> = _countries

    override fun getCountriesApi() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val countries = getCountriesApiUseCase.invoke()
                if (countries.isNotEmpty()){
                    _countries.postValue(countries)
                }

            }
        }
    }
}