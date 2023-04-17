package com.brakai.mytrip.viewmodel.dto

import com.brakai.mytrip.utils.Utils.toStringMonth
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar


data class TripUIDTO(
    override val id: String,
    val displayName: String,
    val displayImage: String,
    val locationName: String,
    val createdAt: Long,
    val updatedAt: Long,
    val completed: Boolean,
    val canceled: Boolean,
    val startAt: Long,
    val endAt: Long
) : StandardStateListItem{

    fun getDurationText() : String{
        val startInstant = Instant.ofEpochSecond(startAt)
        val startLdt = LocalDateTime.ofInstant(startInstant, ZoneId.of("GMT"))
        val startMonth = startLdt.month.value .toStringMonth()
        val startDay = startLdt.dayOfMonth
        val endInstant = Instant.ofEpochSecond(endAt)
        val endLdt = LocalDateTime.ofInstant(endInstant, ZoneId.of("GMT"))
        val endMonth = endLdt.month.value .toStringMonth()
        val endDay = endLdt.dayOfMonth
        val isSameMonth  = startMonth == endMonth

        if (isSameMonth){
            return "$startMonth $startDay-$endDay"
        }

        return "$startMonth $startDay-$endMonth $endDay"
    }
}
