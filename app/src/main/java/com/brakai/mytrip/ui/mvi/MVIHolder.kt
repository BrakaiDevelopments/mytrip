package com.brakai.mytrip.ui.mvi

import androidx.databinding.ViewDataBinding
import com.brakai.mytrip.ui.base.adapter.BaseHolder
import com.brakai.mytrip.viewmodel.dto.StateListItem

abstract class MVIHolder<in I : StateListItem>(
    binding: ViewDataBinding
) : BaseHolder(binding.root) {

    abstract fun bind(item: I)

}
