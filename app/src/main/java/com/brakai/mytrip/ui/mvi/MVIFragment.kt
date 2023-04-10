package com.brakai.mytrip.ui.mvi

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.brakai.mytrip.viewmodel.standard.StandardViewModel
import com.khoshnaw.ui.base.fragment.BaseFragment

abstract class MVIFragment<B : ViewDataBinding, V : StandardViewModel<*, *>>(
    @LayoutRes contentLayoutId: Int
) : BaseFragment(contentLayoutId),
    MVIView<B, V>
