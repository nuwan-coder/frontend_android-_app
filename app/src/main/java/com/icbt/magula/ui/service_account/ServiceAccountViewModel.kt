package com.icbt.magula.ui.service_account

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.ui.listner.AuthListner

class ServiceAccountViewModel(
        private val repository: UserRepository,
        private val viewLifecycleOwner: LifecycleOwner,
        private val activity: FragmentActivity,
        private val context: Context
) : ViewModel() {

    var hotelName:String? = null
    var address:String? = null
    var contactNo:String? = null
    var email:String? = null
    var pricePerPlate:String? = null
    var password:String? = null

    var authListner:AuthListner? = null

    fun onRegistrationButtonClick(view: View){
        if(hotelName.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Hotel name null or empty")
            return
        }
        if(address.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Address null or empty")
            return
        }
        if(contactNo.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Contact number null or empty")
            return
        }
        if(email.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Email null or empty")
            return
        }
        if(pricePerPlate.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Price per plate null or empty")
            return
        }
        if(password.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Password null or empty")
            return
        }
        val serviceRegistrationResponse = repository.serviceRegistration(hotelName!!,address!!,
                contactNo!!,email!!,pricePerPlate!!,password!!)

        if(serviceRegistrationResponse != null){
            authListner?.onSuccess("Registration Successful");
        }else{
            authListner?.onSuccess("Registration fail")
        }
    }

}