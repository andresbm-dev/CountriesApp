package com.abm.countriesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.domain.model.Countries
import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCaseImp
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCase
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCaseImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CountriesViewModelImp @Inject constructor(
    private val getCountriesApiUseCase: GetCountriesApiUseCaseImp,
    private val getCountriesLocalUseCase: GetCountriesLocalUseCaseImp
) : ViewModel(), CountriesViewModel {

    private val _countries: MutableLiveData<List<Countries>> = MutableLiveData()
    val countries: LiveData<List<Countries>> = _countries

    private val _paramCountry: MutableLiveData<Countries> = MutableLiveData()
    val paramCountry: LiveData<Countries> = _paramCountry

    private val _countriesDataBase: MutableLiveData<List<CountriesEntity>> = MutableLiveData()
    val countriesDataBase: LiveData<List<CountriesEntity>> = _countriesDataBase

    private val _progressBar : MutableLiveData<Boolean> = MutableLiveData()
    val progressBar :LiveData<Boolean> = _progressBar

    override fun getCountriesApi() {
        _progressBar.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val countries = getCountriesApiUseCase.invoke()
                    _countries.postValue(countries)
                    _progressBar.postValue(false)
            }
        }
    }

    override fun getCountriesLocal() {
        _progressBar.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _countriesDataBase.postValue(getCountriesLocalUseCase.invoke())
                _progressBar.postValue(false)
            }
        }
    }

    fun sendParams(countries: Countries) {
        _paramCountry.postValue(countries)
    }
}