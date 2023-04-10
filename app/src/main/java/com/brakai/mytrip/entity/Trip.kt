package com.brakai.mytrip.entity



data class Trip (
    val id: String,
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