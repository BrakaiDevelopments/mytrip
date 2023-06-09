package com.brakai.mytrip.ui.standard.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.brakai.mytrip.BR
import com.brakai.mytrip.entity.ErrorMessage
import com.brakai.mytrip.ui.extenstion.runIntentInScope
import com.brakai.mytrip.ui.mvi.MVIFragment
import com.brakai.mytrip.ui.standard.view.StandardView
import com.brakai.mytrip.viewmodel.mvi.MVIIntent
import com.brakai.mytrip.viewmodel.mvi.MVIState
import com.brakai.mytrip.viewmodel.mvi.MVIViewModel
import com.brakai.mytrip.viewmodel.standard.StandardViewModel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class StandardFragment<B : ViewDataBinding, V : StandardViewModel<*, *>>(
    @LayoutRes contentLayoutId: Int
) : MVIFragment<B, V>(contentLayoutId), StandardView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(viewModelVariableId, viewModel)
        viewModel.observeState()
        viewModel.observeError()
        onViewReady()
    }

    fun <I : MVIIntent> MVIViewModel<*, I>.runIntent(intent: I) {
        runIntentInScope(viewLifecycleOwner.lifecycleScope, intent)
    }

    private fun V.observeState() = state.observe(viewLifecycleOwner) { it?.let { handleState(it) } }

    private fun V.observeError() {
        viewLifecycleOwner.lifecycleScope.launch {
            error.receiveAsFlow().collect { showError(it) }
        }
    }

    override fun showError(message: ErrorMessage) {
        if (activity is StandardView<*, *>) {
            val standardActivity = (activity as StandardView<*, *>)
            standardActivity.viewModel.updateError(message)
        }
    }

    override fun onViewReady() = Unit
    override fun handleState(state: MVIState) = Unit
}
