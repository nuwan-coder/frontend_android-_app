package com.icbt.magula.ui.customer_account

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
import com.icbt.magula.ui.listner.AuthListner
import com.icbt.magula.ui.login.LoginViewModel
import com.icbt.magula.ui.login.LoginViewModelFactory
import com.icbt.magula.ui.utils.hide
import com.icbt.magula.ui.utils.show
import com.icbt.magula.ui.utils.toast

class CustomerAccountFragment : Fragment() , AuthListner {

    private lateinit var viewModel: CustomerAccountViewModel
    private lateinit var binding: CustomerAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val api = MyApi();
        val db = AppDatabase(requireContext())
        val repository = UserRepository(api,db)
        val factory = CustomerAccountViewModelFactory(repository,viewLifecycleOwner,requireActivity(),requireContext())

        viewModel = ViewModelProviders.of(this,factory).get(CustomerAccountViewModel::class.java)
        binding = CustomerAccountFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            customerAccountFragment = this@CustomerAccountFragment
            customerAccountViewModel = viewModel
        }
        binding.customerAccountViewModel?.authListner = this
    }

    fun onCancel(){
        findNavController().navigate(R.id.action_customerAccountFragment_to_nav_home)
    }

    override fun onCreate() {
    }

    override fun onSuccess(message: String) {
        context?.toast(message)
    }

    override fun onFailure(message: String) {
        context?.toast(message)
    }

}