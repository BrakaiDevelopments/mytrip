package com.brakai.mytrip.repository.local.mapper

import com.brakai.mytrip.entity.TripDummies
import com.google.common.truth.Truth.assertThat
import com.brakai.mytrip.repository.local.TripLocalDTODummies
import org.junit.Test

class TripMappersKtTest {

    @Test
    fun `mapping dto to entity`() {
        val localDTO = DUMMY_TRIP_LOCAL_DTO
        val entity = DUMMY_TRIP

        val result = localDTO.toEntity()

        assertThat(result).isEqualTo(entity)
    }

    @Test
    fun `mapping dto list to entity list`() {
        val localDTOList = DUMMY_TRIP_LOCAL_DTO_LIST
        val entityList = DUMMY_TRIP_LIST

        val result = localDTOList.toEntity()

        assertThat(result).isEqualTo(entityList)
    }

    @Test
    fun `mapping entity to dto`() {
        val localDTO = DUMMY_TRIP_LOCAL_DTO
        val entity = DUMMY_TRIP

        val result = entity.toLocalDTO()

        assertThat(result).isEqualTo(localDTO)
    }

    @Test
    fun `mapping entity list to dto list`() {
        val localDTOList = DUMMY_TRIP_LOCAL_DTO_LIST
        val entityList = DUMMY_TRIP_LIST

        val result = entityList.toLocalDTO()

        assertThat(result).isEqualTo(localDTOList)
    }

    companion object {
        private val DUMMY_TRIP = TripDummies.trip01
        private val DUMMY_TRIP_LOCAL_DTO = TripLocalDTODummies.dummyTripLocalDTO

        private val DUMMY_TRIP_LIST = TripDummies.dummyTripList
        private val DUMMY_TRIP_LOCAL_DTO_LIST = TripLocalDTODummies.dummyTripLocalDTOList
    }
}