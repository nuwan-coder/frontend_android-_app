package com.icbt.magula.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.icbt.magula.data.db.entyties.Token

@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(token: Token): Long

   // @Query( "SELECT * FROM token WHERE uid=$CURRENT_TOKEN_ID")
   // suspend fun getToken(): LiveData<Token>

}