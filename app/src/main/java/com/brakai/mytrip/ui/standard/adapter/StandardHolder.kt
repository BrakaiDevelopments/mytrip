package com.brakai.mytrip.ui.standard.adapter

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.brakai.mytrip.ui.extenstion.runIntentInScope
import com.brakai.mytrip.ui.mvi.MVIHolder
import com.brakai.mytrip.viewmodel.dto.StandardStateListItem
import com.brakai.mytrip.viewmodel.mvi.MVIIntent
import com.brakai.mytrip.viewmodel.mvi.MVIViewModel

abstract class StandardHolder<in I : StandardStateListItem>(
    private val binding: ViewDataBinding
) : MVIHolder<I>(binding) {

    fun <I : MVIIntent> MVIViewModel<*, I>.runIntent(intent: I) {
        runIntentInScope(binding.root.findViewTreeLifecycleOwner()?.lifecycleScope, intent)
    }

}
