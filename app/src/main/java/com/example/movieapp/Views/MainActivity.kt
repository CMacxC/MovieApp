package com.example.movieapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.ViewModels.MoviesViewModel
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding;
    private lateinit var viewModel: MoviesViewModel;
    private lateinit var adapterMovies: AdapterMovies;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java];

        sutupRecyclerView();

        viewModel.moviesList.observe(this)
        {
            adapterMovies.moviesList = it;
            adapterMovies.notifyDataSetChanged();
        }

        binding.cvBilBoard.setOnClickListener {
            viewModel.getBilboard();
            changeButtonColor("car");
        }

        binding.cvPopulars.setOnClickListener {
            viewModel.getPopulars();
            changeButtonColor("pop");
        }

        viewModel.getBilboard();
    }

    private fun sutupRecyclerView()
    {
        val layoutManager = GridLayoutManager(this, 3);
        binding.rvMovies.layoutManager = layoutManager;
        adapterMovies = AdapterMovies(this, arrayListOf());
        binding.rvMovies.adapter = adapterMovies;
    }

    private fun changeButtonColor(buttom: String)
    {
        when(buttom)
        {
            "car" -> {
                binding.cvBilBoard.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green_200));
                binding.cvPopulars.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.blue_200));
            }

            "pop" -> {
                binding.cvPopulars.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.blue_200));
                binding.cvBilBoard.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.green_200));
            }
        }
    }
}