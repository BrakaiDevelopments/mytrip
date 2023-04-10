package com.brakai.mytrip.viewmodel.main

import com.brakai.mytrip.viewmodel.main.MainIntent
import com.brakai.mytrip.viewmodel.main.MainState
import com.brakai.mytrip.viewmodel.standard.StandardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : StandardViewModel<MainState, MainIntent>()
