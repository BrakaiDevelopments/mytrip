package com.brakai.mytrip.ui.standard.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.brakai.mytrip.BR
import com.brakai.mytrip.R
import com.brakai.mytrip.entity.ErrorMessage
import com.brakai.mytrip.ui.extenstion.runIntentInScope
import com.brakai.mytrip.ui.mvi.MVIActivity
import com.google.android.material.snackbar.Snackbar
import com.brakai.mytrip.ui.standard.view.StandardView
import com.brakai.mytrip.viewmodel.mvi.MVIIntent
import com.brakai.mytrip.viewmodel.mvi.MVIState
import com.brakai.mytrip.viewmodel.mvi.MVIViewModel
import com.brakai.mytrip.viewmodel.standard.StandardViewModel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class StandardActivity<B : ViewDataBinding, V : StandardViewModel<*, *>> :
    MVIActivity<B, V>(), StandardView<B, V> {

    override val viewModelVariableId = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.setVariable(viewModelVariableId, viewModel)
        viewModel.observeState()
        viewModel.observeError()
        onViewReady()
    }

    fun <I : MVIIntent> MVIViewModel<*, I>.runIntent(intent: I) {
        runIntentInScope(lifecycleScope, intent)
    }

    private fun V.observeState() =
        state.observe(this@StandardActivity) { it?.let { handleState(it) } }

    private fun V.observeError() {
        lifecycleScope.launch {
            error.receiveAsFlow().collect { showError(it) }
        }
    }

    override fun showError(message: ErrorMessage) {
        val messageStr = if (message == ErrorMessage.DEFAULT) getString(R.string.default_error)
        else message.message

        showError(messageStr)
    }

    private fun showError(messageStr: String) = Snackbar
        .make(binding.root, messageStr, Snackbar.LENGTH_SHORT)
        .show()

    override fun onViewReady() = Unit
    override fun handleState(state: MVIState) = Unit

}
