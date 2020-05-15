package com.gabrielgrs.moviedb.data.api.model.response.moviedetail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCompaniesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("origin_country") val originCountry: String
) : Serializable