package com.brakai.mytrip.ui.view.trips

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.brakai.mytrip.R
import com.brakai.mytrip.databinding.FragmentTripsBinding
import com.brakai.mytrip.ui.adapter.TripsAdapter
import com.brakai.mytrip.ui.extenstion.dataBindings
import com.brakai.mytrip.ui.standard.fragment.StandardFragment
import com.brakai.mytrip.viewmodel.mvi.MVIState
import com.brakai.mytrip.viewmodel.trips.TripsIntent
import com.brakai.mytrip.viewmodel.trips.TripsState
import com.brakai.mytrip.viewmodel.trips.TripsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TripsFragment : StandardFragment<FragmentTripsBinding, TripsViewModel>(
    R.layout.fragment_trips
) {
    override val binding by dataBindings(FragmentTripsBinding::bind)
    override val viewModel: TripsViewModel by viewModels()
    private val moviesAdapter by lazy { TripsAdapter(viewModel) }

    override fun onViewReady() {
        binding.movieRV.setHasFixedSize(true)
        binding.movieRV.adapter = moviesAdapter
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.runIntent(TripsIntent.RefreshTrips)
        }
    }

    override fun handleState(state: MVIState) {
        when (state) {
            is TripsState.TripList -> handleTripsList(state)
        }
    }

    private fun handleTripsList(tripsState: TripsState.TripList) {
        binding.swipeRefresh.isRefreshing = tripsState.isLoading
        moviesAdapter.items = tripsState.trips
    }

}