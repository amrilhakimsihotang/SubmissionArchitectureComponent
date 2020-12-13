package com.amrilhakimsihotang.submissionarchitecturecomponent.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.amrilhakimsihotang.submissionarchitecturecomponent.local.DummyMovies
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.MoviesModel

class MovieViewModel : ViewModel() {
    fun listObjectMovies(): ObservableArrayList<MoviesModel> {
        val titleMovies = DummyMovies.titleMovies
        val posterMovies = DummyMovies.posterMovies
        val overviewMovies = DummyMovies.overviewMovies
        val director = DummyMovies.director
        val writer = DummyMovies.writer
        val screenplay = DummyMovies.screenplay
        val personcasting = DummyMovies.personcasting

        var list = ObservableArrayList<MoviesModel>()
        titleMovies.forEachIndexed { index, s ->
            var data = MoviesModel(s, posterMovies[index],
                    overviewMovies[index], director[index],
                    writer[index], screenplay[index], personcasting[index])
            list.add(data)
        }
        return list
    }
}