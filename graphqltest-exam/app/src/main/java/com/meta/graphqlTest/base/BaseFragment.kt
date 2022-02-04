package com.meta.graphqlTest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {
    protected lateinit var binding: T
    protected lateinit var viewModel: VM

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getFragment(), container, false)
        viewModel = getViewModel().constructors.first().newInstance() as VM

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    abstract fun getFragment(): Int
    abstract fun getViewModel(): Class<VM>
    abstract fun init()
    abstract fun observe()

}
