package com.icbt.magula.data.network

data class ServiceResponse(
    val address: String,
    val appUserRole: String,
    val contactNo: String,
    val email: String,
    val hotelName: String,
    val id: Long,
    val password: String,
    val pricePerPlate: String
)