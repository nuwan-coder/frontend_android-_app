package com.icbt.magula.ui.choose_account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            chooseAccountFragment = this@ChooseAccountFragment
        }
    }


    fun onNextButtonClick(){

        val accountType = binding.chooseAccountTypeRadioButtonGroup.checkedRadioButtonId

        if(accountType == R.id.service_account_radio_button)
            //goto service fragment
            findNavController().navigate(R.id.action_nav_choose_account_to_nav_service_account)
        else
            //goto customer account fragment
            findNavController().navigate(R.id.action_nav_choose_account_to_customerAccountFragment)

    }

}