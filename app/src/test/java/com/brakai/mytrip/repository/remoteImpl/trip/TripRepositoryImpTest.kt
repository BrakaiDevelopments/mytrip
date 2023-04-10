package com.brakai.mytrip.repository.remoteImpl.trip

import com.google.common.truth.Truth.assertThat
import com.brakai.mytrip.repository.local.TripLocalDTODummies
import com.brakai.mytrip.repository.local.dataSource.TripLocalDataSource
import com.brakai.mytrip.repository.local.mapper.toEntity
import com.brakai.mytrip.repository.remote.TripRemoteDTODummies
import com.brakai.mytrip.repository.remote.dataSource.TripRemoteDataSource
import com.brakai.mytrip.repository.repositoryImp.TripRepositoryImp
import io.mockk.MockKAnnotations
import io.mockk.Ordering
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class TripRepositoryImpTest {
    @MockK
    lateinit var movieRemoteDataSource: TripRemoteDataSource

    @MockK
    lateinit var movieLocalDataSource: TripLocalDataSource

    @InjectMockKs
    lateinit var repository: TripRepositoryImp

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `use remote data source to load movie list`() = runBlocking {
        coEvery { movieRemoteDataSource.loadTripList() } returns DUMMY_TRIP_REMOTE_LIST

        repository.updateTripList()

        coVerify(exactly = 1) { movieRemoteDataSource.loadTripList() }
    }

    @Test
    fun `use local data source to update movie list`() = runBlocking {
        coEvery { movieRemoteDataSource.loadTripList() } returns DUMMY_TRIP_REMOTE_LIST

        repository.updateTripList()

        coVerify(exactly = 1) { movieLocalDataSource.updateTripList(DUMMY_TRIP_LOCAL_LIST) }
    }

    @Test
    fun `load movies from remote and update local`() = runBlocking {
        coEvery { movieRemoteDataSource.loadTripList() } returns DUMMY_TRIP_REMOTE_LIST

        repository.updateTripList()

        coVerify(ordering = Ordering.SEQUENCE) {
            movieRemoteDataSource.loadTripList()
            movieLocalDataSource.updateTripList(DUMMY_TRIP_LOCAL_LIST)
        }
    }

    @Test
    fun `use local data source to observe movies`() = runBlocking {
        val dummyMovieList = DUMMY_LOCAL_TRIP_LIST_FLOW.toList().map { it.toEntity() }
        coEvery { movieLocalDataSource.observeTrips() } returns DUMMY_LOCAL_TRIP_LIST_FLOW

        val result = repository.observeTrips().toList()

        coVerify(exactly = 1) { movieLocalDataSource.observeTrips() }
        assertThat(result.toList()).isEqualTo(dummyMovieList)
    }

    @Test
    fun `use local data source to load local movie list size`() = runBlocking {
        coEvery { movieLocalDataSource.loadTripSize() } returns DUMMY_TRIP_LIST_SIZE

        val result = repository.loadTripSize()

        coVerify(exactly = 1) { movieLocalDataSource.loadTripSize() }
        assertThat(result).isEqualTo(DUMMY_TRIP_LIST_SIZE)
    }

    companion object {
        private val DUMMY_TRIP_REMOTE_LIST = TripRemoteDTODummies.dummyTripRemoteDTOList
        private val DUMMY_TRIP_LOCAL_LIST = TripLocalDTODummies.dummyTripLocalDTOList
        private val DUMMY_LOCAL_TRIP_LIST_FLOW = flow {
            emit(DUMMY_TRIP_LOCAL_LIST)
        }
        private const val DUMMY_TRIP_LIST_SIZE = 2
    }
}