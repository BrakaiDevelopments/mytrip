package com.brakai.mytrip.ui.extenstion

import androidx.lifecycle.LifecycleCoroutineScope
import com.brakai.mytrip.usecase.utils.tryTo
import com.brakai.mytrip.viewmodel.mvi.MVIIntent
import com.brakai.mytrip.viewmodel.mvi.MVIViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

fun <I : MVIIntent> MVIViewModel<*, I>.runIntentInScope(
    scope: LifecycleCoroutineScope?,
    intent: I
) {
    scope?.launch(Dispatchers.IO) {
        val exception = tryTo { intents.send(intent) }
        Timber.e(exception)
    }
}
