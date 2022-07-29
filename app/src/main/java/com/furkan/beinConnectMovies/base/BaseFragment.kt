package com.furkan.beinConnectMovies.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel> : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding

    abstract val viewModel: VM

    open fun observerData(){}
    abstract fun onCreateFinished()

    abstract fun layoutResource(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = layoutResource(inflater, container)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateFinished()
        observerData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}