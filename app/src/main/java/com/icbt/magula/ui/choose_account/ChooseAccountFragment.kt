package com.icbt.magula.ui.choose_account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.icbt.magula.R
import com.icbt.magula.databinding.ChooseAccountFragmentBinding

class ChooseAccountFragment : Fragment() {

    private val viewModel: ChooseAccountViewModel by viewModels()
    private lateinit var binding:ChooseAccountFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = ChooseAccountFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

}