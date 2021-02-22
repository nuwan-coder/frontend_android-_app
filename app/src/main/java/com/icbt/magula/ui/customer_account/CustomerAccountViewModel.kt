package com.icbt.magula.ui.customer_account

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.ui.listner.AuthListner

class CustomerAccountViewModel(
        private val repository: UserRepository,
        private val viewLifecycleOwner: LifecycleOwner,
        private val activity: FragmentActivity,
        private val context: Context
) : ViewModel() {

    var firstName:String? = null
    var lastName:String? = null
    var userName:String? = null
    var email:String? = null
    var nic:String? = null
    var contactNo:String? = null
    var password:String? = null

    var authListner:AuthListner? = null

    fun onRegistrationButtonClick(view:View){
        if(firstName.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("First name null or empty")
            return
        }
        if(lastName.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Last name null or empty")
            return
        }
        if(userName.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Username null or empty")
            return
        }
        if(email.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Email null or empty")
            return
        }
        if(nic.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Nic null or empty")
            return
        }
        if(contactNo.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Contact number null or empty")
            return
        }
        if(password.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Password null or empty")
            return
        }

        val registrationResponse = repository.userRegistration(firstName!!, lastName!!, userName!!
                , email!!, nic!!, contactNo!!, password!!);

        if(registrationResponse != null){
            authListner?.onSuccess("Login Successful");
        }else{
            authListner?.onSuccess("login fail")
        }
    }

}