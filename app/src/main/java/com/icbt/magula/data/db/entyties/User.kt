package com.icbt.magula.data.db.entyties

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0L

@Entity
data class User(
    var id:Long? = null,
    var firstName:String? = null,
    var lastName:String? = null,
    var username:String? = null,
    var email:String? = null,
    var nic:String? = null,
    var contactNo:String? = null,
    var password:String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uid: Long = CURRENT_USER_ID
}