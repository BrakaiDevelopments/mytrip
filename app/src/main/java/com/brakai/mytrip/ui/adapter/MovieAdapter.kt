package com.brakai.mytrip.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.brakai.mytrip.databinding.TripItemBinding
import com.brakai.mytrip.ui.standard.adapter.StandardAdapter
import com.brakai.mytrip.ui.standard.adapter.StandardHolder
import com.brakai.mytrip.viewmodel.dto.TripUIDTO
import com.brakai.mytrip.viewmodel.trips.TripsIntent
import com.brakai.mytrip.viewmodel.trips.TripsViewModel

class TripsAdapter(
    private val viewModel: TripsViewModel
) : StandardAdapter<TripUIDTO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieHolder(
        TripItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class MovieHolder(
        private val binding: TripItemBinding
    ) : StandardHolder<TripUIDTO>(binding) {

        override fun bind(item: TripUIDTO) {
            binding.trip = item
            binding.containerCV.setOnClickListener {
                viewModel.runIntent(TripsIntent.OnTripClicked(adapterPosition, item.id))
            }
        }
    }
}
