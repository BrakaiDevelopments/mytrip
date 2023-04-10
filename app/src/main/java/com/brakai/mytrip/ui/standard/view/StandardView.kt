package com.brakai.mytrip.ui.standard.view

import androidx.databinding.ViewDataBinding
import com.brakai.mytrip.entity.ErrorMessage
import com.brakai.mytrip.ui.mvi.MVIView
import com.brakai.mytrip.viewmodel.mvi.MVIState
import com.brakai.mytrip.viewmodel.standard.StandardViewModel

interface StandardView<B : ViewDataBinding, V : StandardViewModel<*, *>> : MVIView<B, V> {
    fun showError(message: ErrorMessage)
    fun handleState(state: MVIState)
}
