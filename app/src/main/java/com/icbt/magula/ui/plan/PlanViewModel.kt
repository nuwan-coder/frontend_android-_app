package com.icbt.magula.ui.plan

import android.content.Context
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icbt.magula.data.network.Coroutines
import com.icbt.magula.data.network.ServiceResponse
import com.icbt.magula.data.repository.UserRepository
import kotlinx.coroutines.Job

class PlanViewModel(
        private val repository: UserRepository,
        private val viewLifecycleOwner: LifecycleOwner,
        private val activity: FragmentActivity,
        private val context: Context
) : ViewModel() {

    var budget:String? = null
    var nop:String? = null

    fun onFindButtonClick(view:View){
        Log.d("d","button was click")
    }

    private lateinit var job: Job
    private val _selectedServices = MutableLiveData<List<ServiceResponse>>()

    val selectedServices : LiveData<List<ServiceResponse>>
        get() = _selectedServices

    fun getSelectedServices(){
        job = Coroutines.ioTheMain(
                {repository.getSelectedService(budget!!,nop!!)},
                {
                    _selectedServices.value = it
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}