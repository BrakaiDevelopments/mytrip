package com.brakai.mytrip.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.brakai.mytrip.repository.local.dto.TripLocalDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDao {
    @Insert(onConflict = REPLACE)
    fun insertAll(list: List<TripLocalDTO>)

    @Query("SELECT * FROM trip")
    fun observeTrips(): Flow<List<TripLocalDTO>>

    @Query("SELECT COUNT(*) FROM trip")
    fun loadTripSize(): Int
}