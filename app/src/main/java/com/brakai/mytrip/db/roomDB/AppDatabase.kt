package com.brakai.mytrip.db.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brakai.mytrip.db.dao.TripDao
import com.brakai.mytrip.repository.local.dto.TripLocalDTO

@Database(entities = [TripLocalDTO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao
}