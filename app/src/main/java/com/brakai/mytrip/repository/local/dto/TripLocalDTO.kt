package com.brakai.mytrip.repository.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brakai.mytrip.entity.Destination
import java.util.UUID

@Entity(tableName = "trip")
data class TripLocalDTO (
    @PrimaryKey val id: UUID,
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