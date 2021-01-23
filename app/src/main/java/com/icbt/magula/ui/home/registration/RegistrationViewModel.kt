package com.icbt.magula.ui.home.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Registration fragment"
    }

    val text:LiveData<String> = _text
}