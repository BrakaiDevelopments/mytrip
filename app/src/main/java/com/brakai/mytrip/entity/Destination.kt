package com.brakai.mytrip.entity

import java.util.*

data class Destination(
    val id: String,
    val displayName: String,
    val createdAt: Long,
    val updatedAt: Long,
    val visited: Boolean
)
