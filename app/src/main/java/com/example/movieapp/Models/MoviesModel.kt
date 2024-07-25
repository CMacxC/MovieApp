package com.example.movieapp.Models

import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var movieName: String,
    @SerializedName("overview")
    var description: String,
    @SerializedName("poster_path")
    var poster: String,
    @SerializedName("release_date")
    var dateRelease: String,
    @SerializedName("vote_average")
    var calification: Double,
    @SerializedName("vote_account")
    var totalVotes: Int

)
