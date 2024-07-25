package com.example.movieapp.Views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.Core.Constants
import com.example.movieapp.Models.MoviesModel
import com.example.movieapp.R

class AdapterMovies(val context: Context, var moviesList: List<MoviesModel>): RecyclerView.Adapter<AdapterMovies.ViewHolder>()
{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val cvMovies = itemView.findViewById(R.id.cvMovie) as CardView;
        val ivPoster = itemView.findViewById(R.id.ivPoster) as ImageView;
        val pcIndicator = itemView.findViewById(R.id.circular_progress) as CircularProgressIndicator;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMovies.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_movie, parent, false);

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: AdapterMovies.ViewHolder, position: Int) {
        val movie = moviesList[position];

        Glide.with(context)
            .load("${Constants.BASE_URL_IMAGES}${movie.poster}")
            .apply(RequestOptions().override(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGTH))
            .into(holder.ivPoster);

        holder.pcIndicator.maxProgress = Constants.MAX_CALIFICATION;
        holder.pcIndicator.setCurrentProgress(movie.calification.toDouble());
    }

    override fun getItemCount(): Int {
        return moviesList.size;
    }

}