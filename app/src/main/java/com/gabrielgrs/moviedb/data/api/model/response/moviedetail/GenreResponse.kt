package com.gabrielgrs.moviedb.data.api.model.response.moviedetail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
) : Serializable