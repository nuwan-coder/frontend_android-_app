package com.icbt.magula.ui.listner

interface AuthListner {
    fun onCreate()
    fun onSuccess(message: String)
    fun onFailure(message:String)
}