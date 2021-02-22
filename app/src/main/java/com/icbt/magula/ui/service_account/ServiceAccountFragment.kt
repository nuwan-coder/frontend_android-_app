package com.icbt.magula.ui.service_account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.icbt.magula.R
import com.icbt.magula.data.db.AppDatabase
import com.icbt.magula.data.network.MyApi
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.databinding.CustomerAccountFragmentBinding
import com.icbt.magula.databinding.ServiceAccountFragmentBinding
import com.icbt.magula.ui.customer_account.CustomerAccountViewModel
import com.icbt.magula.ui.customer_account.CustomerAccountViewModelFactory
import com.icbt.magula.ui.listner.AuthListner
import com.icbt.magula.ui.utils.toast

class ServiceAccountFragment : Fragment(),AuthListner {

    private lateinit var viewModel: ServiceAccountViewModel
    private lateinit var binding:ServiceAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val api = MyApi();
        val db = AppDatabase(requireContext())
        val repository = UserRepository(api,db)
        val factory = ServiceAccountViewModelFactory(repository,viewLifecycleOwner,requireActivity(),requireContext())

        viewModel = ViewModelProviders.of(this,factory).get(ServiceAccountViewModel::class.java)
        binding = ServiceAccountFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            serviceAccountFragment = this@ServiceAccountFragment
            serviceAccountViewModel = viewModel
        }
        binding.serviceAccountViewModel?.authListner = this
    }


    fun onCancel(){
        findNavController().navigate(R.id.action_nav_service_account_to_nav_home)
    }

    override fun onCreate() {

    }

    override fun onSuccess(message: String) {
        context?.toast(message)
        findNavController().navigate(R.id.action_nav_service_account_to_nav_home)
    }

    override fun onFailure(message: String) {
        context?.toast(message)
    }

}