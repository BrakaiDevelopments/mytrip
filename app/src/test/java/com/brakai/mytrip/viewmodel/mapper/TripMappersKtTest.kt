package com.brakai.mytrip.viewmodel.mapper

import com.brakai.mytrip.entity.TripDummies
import com.brakai.mytrip.ui.mapper.toUIDTO
import com.brakai.mytrip.viewmodel.dummy.TripsUIDTODummies
import com.google.common.truth.Truth
import org.junit.Test

class TripMappersKtTest {

    @Test
    fun `mapping entity to dto`() {
        val dto = DUMMY_TRIP_UI_DTO
        val entity = DUMMY_TRIP

        val result = entity.toUIDTO()

        Truth.assertThat(result).isEqualTo(dto)
    }

    @Test
    fun `mapping entity list to dto list`() {
        val dtoList = DUMMY_TRIP_UI_DTO_LIST
        val entityList = DUMMY_TRIP_LIST

        val result = entityList.toUIDTO()

        Truth.assertThat(result).isEqualTo(dtoList)
    }

    companion object {
        private val DUMMY_TRIP = TripDummies.trip01
        private val DUMMY_TRIP_UI_DTO = TripsUIDTODummies.dummyTripUIDTO

        private val DUMMY_TRIP_LIST = TripDummies.dummyTripList
        private val DUMMY_TRIP_UI_DTO_LIST = TripsUIDTODummies.dummyTripUIDTOList
    }
}
