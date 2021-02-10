package com.icbt.magula.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.icbt.magula.data.db.AppDatabase
import com.icbt.magula.data.db.entyties.Token
import com.icbt.magula.data.network.Login
import com.icbt.magula.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
        private val api: MyApi,
        private val db:AppDatabase
) {

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

    suspend fun saveToken(token:Token) = db.getTokenDao().upsert(token)

    //suspend fun getToken() = db.getTokenDao().getToken()
}