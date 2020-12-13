package com.amrilhakimsihotang.submissionarchitecturecomponent.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.amrilhakimsihotang.submissionarchitecturecomponent.viewmodel.MovieViewModel
import com.amrilhakimsihotang.submissionarchitecturecomponent.adapter.MoviesAdapter
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var binding: FragmentMovieBinding
    private lateinit var movieViewModel: MovieViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        movieViewModel=ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)
        moviesAdapter = MoviesAdapter(movieViewModel.listObjectMovies())
        binding.rvmovies.layoutManager=GridLayoutManager(requireActivity(),2)
        binding.rvmovies.setHasFixedSize(true)
        binding.rvmovies.adapter= moviesAdapter

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieBinding.inflate(inflater,container,false)
        val view= binding.root
        return view
    }

}