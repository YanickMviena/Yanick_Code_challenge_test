package com.yanic.api.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yanic.api.model.Card
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(cards: List<Card>)

    @Query("SELECT * FROM Card")
    fun getCards(): Flow<List<Card>>
}