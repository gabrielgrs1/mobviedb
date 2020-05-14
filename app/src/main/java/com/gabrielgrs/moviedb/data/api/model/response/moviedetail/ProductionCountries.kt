package com.gabrielgrs.moviedb.data.api.model.response.moviedetail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCountries(
    @SerializedName("name") val name: String,
    @SerializedName("iso_3166_1") val iso31661: String
) : Serializable