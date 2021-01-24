package com.icbt.magula.ui.service_account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.icbt.magula.R
import com.icbt.magula.databinding.ServiceAccountFragmentBinding

class ServiceAccountFragment : Fragment() {

    private val viewModel: ServiceAccountViewModel by viewModels()
    private lateinit var binding:ServiceAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ServiceAccountFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

}