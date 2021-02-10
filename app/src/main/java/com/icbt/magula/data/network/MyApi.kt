package com.icbt.magula.data.network

import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

    @POST("login")
    fun login(@Body login: Login) : Call<ResponseBody>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                    .baseUrl("http://192.168.1.3:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MyApi::class.java)
        }
    }

}