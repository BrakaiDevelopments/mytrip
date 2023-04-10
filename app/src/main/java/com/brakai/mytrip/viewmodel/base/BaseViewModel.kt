package com.brakai.mytrip.viewmodel.base

import androidx.lifecycle.ViewModel
import com.brakai.mytrip.usecase.trip.base.OutputPort

abstract class BaseViewModel : ViewModel(), OutputPort
