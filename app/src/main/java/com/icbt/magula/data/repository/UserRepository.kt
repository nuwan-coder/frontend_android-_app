package com.icbt.magula.data.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.icbt.magula.data.db.AppDatabase
import com.icbt.magula.data.network.*
import com.icbt.magula.ui.listner.RecyclerViewClickListner
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
        private val api: MyApi,
        private val db:AppDatabase
) : SafeApiRequest() {

    fun userLogin(email:String, password:String): LiveData<String> {
        val loginResponse = MutableLiveData<String>()

        api.login(Login(email,password)).enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginResponse.value = t.message
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    loginResponse.value = response.headers()?.get("Authorization")
                }else{
                    loginResponse.value = response.errorBody()?.string()
                }
            }

        })
        return loginResponse
    }

    fun userRegistration(firstName: String, lastName: String, username: String, email: String,
                         nic: String, contactNo: String, password: String):LiveData<String>{
        val registrationResponse = MutableLiveData<String>()

        api.registration(Registration(firstName, lastName, username, email, nic, contactNo, password))
                .enqueue(object :Callback<ResponseBody>{
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        registrationResponse.value = t.message
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if(response.isSuccessful){
                            registrationResponse.value = response.body()?.string()
                        }else{
                            registrationResponse.value = response.errorBody()?.string()
                        }
                    }

                })
        return registrationResponse

    }

    fun serviceRegistration(hotelName:String, address:String, contactNo:String, email:String,
                         pricePerPlate:String, password:String):LiveData<String>{
        val serviceRegistrationResponse = MutableLiveData<String>()

        api.serviceRegistration(ServiceRegistration(hotelName, address, contactNo, email, pricePerPlate, password))
                .enqueue(object :Callback<ResponseBody>{
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        serviceRegistrationResponse.value = t.message
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if(response.isSuccessful){
                            serviceRegistrationResponse.value = response.body()?.string()
                        }else{
                            serviceRegistrationResponse.value = response.errorBody()?.string()
                        }
                    }

                })
        return serviceRegistrationResponse

    }

    suspend fun getServices() = apiRequest { api.getUsers() }

    suspend fun getSelectedService(budget:String,nop:String) =
            apiRequest { api.getSuitableUsers(SelectServiceRequest(budget,nop)) }
}