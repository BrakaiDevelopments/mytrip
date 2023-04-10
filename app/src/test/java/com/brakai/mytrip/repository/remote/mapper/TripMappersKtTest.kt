package com.brakai.mytrip.repository.remote.mapper

import com.brakai.mytrip.entity.TripDummies
import com.brakai.mytrip.repository.remote.TripRemoteDTODummies
import com.google.common.truth.Truth
import org.junit.Test

class TripMappersKtTest {

    @Test
    fun `mapping dto to entity`() {
        val dto = DUMMY_TRIP_DTO
        val entity = DUMMY_TRIP

        val result = dto.toEntity()

        Truth.assertThat(result).isEqualTo(entity)
    }

    @Test
    fun `mapping dto list to entity list`() {
        val dtoList = DUMMY_TRIP_DTO_LIST
        val entityList = DUMMY_TRIP_LIST

        val result = dtoList.toEntity()

        Truth.assertThat(result).isEqualTo(entityList)
    }

    companion object {
        private val DUMMY_TRIP = TripDummies.trip01
        private val DUMMY_TRIP_DTO = TripRemoteDTODummies.dummyTripRemoteDTO

        private val DUMMY_TRIP_LIST = TripDummies.dummyTripList
        private val DUMMY_TRIP_DTO_LIST = TripRemoteDTODummies.dummyTripRemoteDTOList
    }
}