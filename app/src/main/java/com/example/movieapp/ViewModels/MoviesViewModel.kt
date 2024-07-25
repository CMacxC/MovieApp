package com.example.movieapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.Core.Constants
import com.example.movieapp.Models.MoviesModel
import com.example.movieapp.Network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel: ViewModel()
{
    private var _moviesList = MutableLiveData<List<MoviesModel>>();
    val moviesList: LiveData<List<MoviesModel>> = _moviesList;

    fun getBilboard()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getBilboard(Constants.API_KEY);

            withContext(Dispatchers.Main){
                _moviesList.value = response.body()!!.result.sortedByDescending { it.calification }
            }
        }
    }

    fun getPopulars()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getPopulars(Constants.API_KEY);

            withContext(Dispatchers.Main){
                _moviesList.value = response.body()!!.result.sortedByDescending { it.calification }
            }
        }
    }
}