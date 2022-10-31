package com.abm.countriesapp.domain.model

import com.google.gson.annotations.SerializedName

class ResponseCountries: ArrayList<Countries>()

data class Countries(
    @SerializedName("name") var nameCountry : NameCountry? = null,
    @SerializedName("capital") var capital :List<String>? = null,
    @SerializedName("borders") var borders :List<String>? = null,
    @SerializedName("flags") var flag : FlagsCountries? = null,
    @SerializedName("independent") var independent : Boolean? = null,
    @SerializedName("region") var region : String? = null,
    @SerializedName("area") var area : Double? = null,
    @SerializedName("population") var population : String? = null,
    @SerializedName("continents") var continents : List<String>? = null,
    )

data class FlagsCountries(
    @SerializedName("png") var flagPng :String? = null,
    @SerializedName("svg") var flagSvg :String? = null
)

data class NameCountry (
    @SerializedName("common") var nameCommon : String?=null,
    @SerializedName("official") var nameOfficial : String?=null
)

