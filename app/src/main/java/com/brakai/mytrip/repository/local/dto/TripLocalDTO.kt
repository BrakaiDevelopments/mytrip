package com.brakai.mytrip.repository.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip")
data class TripLocalDTO (
    @PrimaryKey val id: String,
    val displayName: String,
    val displayImage: String,
    val locationName: String,
    val createdAt: Long,
    val updatedAt: Long,
    val completed: Boolean,
    val canceled: Boolean,
    val startAt: Long,
    val endAt: Long
)