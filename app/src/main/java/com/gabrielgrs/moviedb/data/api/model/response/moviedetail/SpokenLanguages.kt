package com.gabrielgrs.moviedb.data.api.model.response.moviedetail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpokenLanguages(
    @SerializedName("name") val name: String,
    @SerializedName("iso_639_1") val iso6931: String
) : Serializable