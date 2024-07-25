package com.example.movieapp.Network

import com.example.movieapp.Network.reponse.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService
{
    @GET("now_playing")
    suspend fun getBilboard(
        @Query("api_key") apiKey: String
    ): Response<MoviesResponse>

    @GET("popular")
    suspend fun getPopulars(
        @Query("api_key") spiKey: String
    ): Response<MoviesResponse>
}