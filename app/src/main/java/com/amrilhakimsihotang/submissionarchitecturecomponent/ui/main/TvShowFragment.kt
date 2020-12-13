package com.amrilhakimsihotang.submissionarchitecturecomponent.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.amrilhakimsihotang.submissionarchitecturecomponent.adapter.TiviShowAdapter
import com.amrilhakimsihotang.submissionarchitecturecomponent.databinding.FragmentTvShowBinding
import com.amrilhakimsihotang.submissionarchitecturecomponent.local.DummyTivi
import com.amrilhakimsihotang.submissionarchitecturecomponent.model.TiviModel
import com.amrilhakimsihotang.submissionarchitecturecomponent.viewmodel.TivishowViewModel


class TvShowFragment : Fragment() {

    private lateinit var tiviShowAdapter: TiviShowAdapter
    private lateinit var binding: FragmentTvShowBinding
    private lateinit var tivishowViewModel: TivishowViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tivishowViewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory()).get(TivishowViewModel::class.java)
        tiviShowAdapter = TiviShowAdapter(tivishowViewModel.listObjectTivi())

        binding.rvtivi.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvtivi.setHasFixedSize(true)
        binding.rvtivi.adapter = tiviShowAdapter
    }

}