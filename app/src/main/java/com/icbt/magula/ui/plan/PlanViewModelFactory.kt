package com.icbt.magula.ui.plan

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.icbt.magula.data.repository.UserRepository

class PlanViewModelFactory(
        private val repository: UserRepository,
        private val viewLifecycleOwner: LifecycleOwner,
        private val activity: FragmentActivity,
        private val context: Context
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlanViewModel(repository,viewLifecycleOwner,activity,context) as T
    }
}