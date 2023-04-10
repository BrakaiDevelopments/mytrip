package com.brakai.mytrip.ui.mvi

import androidx.databinding.ViewDataBinding
import com.brakai.mytrip.viewmodel.mvi.MVIViewModel

interface MVIView<B : ViewDataBinding, V : MVIViewModel<*, *>> {
    val binding: B
    val viewModel: V
    val viewModelVariableId: Int

    fun onViewReady()
}
