package com.abm.countriesapp.model.usecase

import com.google.gson.annotations.SerializedName

class ResponseCountries: ArrayList<Countries>()

data class Countries(
@SerializedName("name") var nameCountry :NameCountry? = null,
@SerializedName("capital") var capital :List<String>? = null,
@SerializedName("borders") var borders :List<String>? = null,

)
data class NameCountry (
    @SerializedName("common") var nameCommon : String?=null,
    @SerializedName("official") var nameOfficial : String?=null
)

