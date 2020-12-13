package com.amrilhakimsihotang.submissionarchitecturecomponent.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.amrilhakimsihotang.submissionarchitecturecomponent.local.DummyTivi
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.TiviModel

class TivishowViewModel : ViewModel() {
    fun listObjectTivi(): ObservableArrayList<TiviModel> {
        val titleTvshow = DummyTivi.titleTvshow
        val posterTvshow = DummyTivi.posterTvshow
        val overviewTvshow = DummyTivi.overviewTvshow
        val creatorcast = DummyTivi.creatorcast
        val seriescast = DummyTivi.seriescast
        val writingcast = DummyTivi.writingcast

        val list = ObservableArrayList<TiviModel>()
        titleTvshow.forEachIndexed { index, s ->
            var data = TiviModel(s, posterTvshow[index], overviewTvshow[index],
                    creatorcast[index], seriescast[index], writingcast[index])
            list.add(data)
        }
        return list
    }
}