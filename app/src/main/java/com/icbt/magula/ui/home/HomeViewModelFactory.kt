package com.icbt.magula.ui.home

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.ui.customer_account.CustomerAccountViewModel

class HomeViewModelFactory(
        private val repository: UserRepository,
        private val viewLifecycleOwner: LifecycleOwner,
        private val activity: FragmentActivity,
        private val context: Context
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository,viewLifecycleOwner,activity,context) as T
    }
}