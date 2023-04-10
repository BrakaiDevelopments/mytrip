package com.brakai.mytrip.ui.mvi

import androidx.databinding.ViewDataBinding
import com.brakai.mytrip.ui.base.activity.BaseActivity
import com.brakai.mytrip.viewmodel.standard.StandardViewModel

abstract class MVIActivity<B : ViewDataBinding, V : StandardViewModel<*, *>> :
    BaseActivity(),
    MVIView<B, V>
