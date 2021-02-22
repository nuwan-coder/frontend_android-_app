package com.icbt.magula.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.icbt.magula.data.repository.UserRepository
import com.icbt.magula.ui.listner.AuthListner

class LoginViewModel(
    private val repository: UserRepository,
    private val viewLifecycleOwner: LifecycleOwner,
    private val activity: FragmentActivity,
    private val context: Context
) : ViewModel() {

    var email:String? = null
    var password:String? = null

    var authListner:AuthListner? = null

    fun onLoginButtonClick(view: View){
        authListner!!.onCreate()
        if(email.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Username null or empty")
            return
        }
        if(password.isNullOrEmpty()){
            //show error msg
            authListner!!.onFailure("Password is null or empty")
            return
        }
        //success
        val loginResponse = repository.userLogin(email!!,password!!)
        if(loginResponse!=null){

            loginResponse.observe(viewLifecycleOwner, Observer {
               authListner?.onSuccess(it)
                val sp:SharedPreferences =
                    activity.getSharedPreferences("token",Context.MODE_PRIVATE)
                val editor:SharedPreferences.Editor = sp.edit()
                editor.putString("token",it)
                editor.apply()
                editor.commit()
            })
            authListner?.onSuccess("Login Successful")

        }
    }

    fun onCancelButtonClick(view:View){
        val sp:SharedPreferences =
            activity.getSharedPreferences("token",Context.MODE_PRIVATE)
        val sharedIdValue = sp.getString("token","defaultname")
        authListner?.onSuccess(sharedIdValue.toString())
    }

}