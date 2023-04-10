package com.brakai.mytrip.ui.view.main

import androidx.activity.viewModels
import com.brakai.mytrip.databinding.ActivityMainBinding
import com.brakai.mytrip.ui.extenstion.dataBindings
import com.brakai.mytrip.ui.standard.activity.StandardActivity
import com.brakai.mytrip.viewmodel.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : StandardActivity<ActivityMainBinding, MainViewModel>() {
    override val binding by dataBindings(ActivityMainBinding::inflate)
    override val viewModel: MainViewModel by viewModels()
}