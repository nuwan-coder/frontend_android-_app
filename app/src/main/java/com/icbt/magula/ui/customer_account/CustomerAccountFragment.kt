package com.icbt.magula.ui.customer_account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.icbt.magula.R
import com.icbt.magula.databinding.CustomerAccountFragmentBinding

class CustomerAccountFragment : Fragment() {

    private val viewModel: CustomerAccountViewModel by viewModels()
    private lateinit var binding: CustomerAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CustomerAccountFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

}