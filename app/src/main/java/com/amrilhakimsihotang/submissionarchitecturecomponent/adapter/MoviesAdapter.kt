package com.amrilhakimsihotang.submissionarchitecturecomponent.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrilhakimsihotang.submissionarchitecturecomponent.DetailMoviesActivity
import com.amrilhakimsihotang.submissionarchitecturecomponent.R
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.ListMoviesBinding
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.MoviesModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter(private val listMovies: ArrayList<MoviesModel>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    inner class MoviesViewHolder(val binding: ListMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moviesModel: MoviesModel) {
            Glide.with(itemView.context)
                .load(moviesModel.poster_path)
                .apply(RequestOptions().override(800, 600))
                .error(R.drawable.ic_baseline_tag_faces_24)
                .into(binding.imgPosterMovies)
            binding.movieTitle.text = moviesModel.original_title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ListMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(listMovies[position])
        val moviesData = listMovies[position]
        holder.itemView.setOnClickListener {
            val moviesIntent = MoviesModel(
                moviesData.original_title,
                moviesData.poster_path,
                moviesData.overview,
                moviesData.director,
                moviesData.writer,
                moviesData.screenplay,
                moviesData.person_cast
            )
            val mIntent = Intent(it.context, DetailMoviesActivity::class.java)
            mIntent.putExtra(DetailMoviesActivity.DETAIL_MOVIES, moviesIntent)
            it.context.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

}