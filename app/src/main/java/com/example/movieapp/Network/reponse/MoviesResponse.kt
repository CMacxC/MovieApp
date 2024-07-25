package com.example.movieapp.Network.reponse

import com.example.movieapp.Models.MoviesModel
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    var result: List<MoviesModel>
)
