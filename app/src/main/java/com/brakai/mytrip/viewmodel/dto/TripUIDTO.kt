package com.brakai.mytrip.viewmodel.dto

import java.util.UUID

data class TripUIDTO(
    override val id: UUID,
    val displayName: String,
    val displayImage: String,
    val locationName: String,
    val createdAt: Long,
    val updatedAt: Long,
    val completed: Boolean,
    val canceled: Boolean,
    val startAt: Long,
    val endAt: Long
) : StandardStateListItem
