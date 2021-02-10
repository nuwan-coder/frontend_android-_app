package com.icbt.magula.data.db.entyties

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_TOKEN_ID = 0

@Entity
data class Token(
        var id:Int? = null,
        var token:String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_TOKEN_ID
}