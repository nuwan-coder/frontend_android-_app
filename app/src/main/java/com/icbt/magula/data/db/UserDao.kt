package com.icbt.magula.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.icbt.magula.data.db.entyties.CURRENT_USER_ID
import com.icbt.magula.data.db.entyties.User

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user:User): Long

    @Query( "SELECT * FROM user WHERE uid= $CURRENT_USER_ID")
    fun getUser(): LiveData<User>

}