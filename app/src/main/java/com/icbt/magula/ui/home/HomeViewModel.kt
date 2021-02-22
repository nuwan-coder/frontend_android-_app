package com.icbt.magula.ui.home

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icbt.magula.data.network.Coroutines
import com.icbt.magula.data.network.ServiceResponse
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.ui.listner.AuthListner
import kotlinx.coroutines.Job

class HomeViewModel(
        private val repository: UserRepository,
        private val viewLifecycleOwner: LifecycleOwner,
        private val activity: FragmentActivity,
        private val context: Context
) : ViewModel() {

    var authListner:AuthListner? = null
    private lateinit var job:Job
    private val _services = MutableLiveData<List<ServiceResponse>>()

    val services : LiveData<List<ServiceResponse>>
        get() = _services

    fun getServices(){
        job = Coroutines.ioTheMain(
                {repository.getServices()},
                {
                    _services.value = it
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}