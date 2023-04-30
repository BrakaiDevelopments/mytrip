package com.brakai.mytrip.viewmodel.trips

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewModelScope
import com.brakai.mytrip.usecase.trip.loadTripList.LoadTripListInputPort
import com.brakai.mytrip.viewmodel.util.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class TripsViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = CoroutineTestRule()

    @MockK
    lateinit var loadTripListInputPort: LoadTripListInputPort

    @InjectMockKs
    lateinit var viewModel: TripsViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel.viewModelScope
    }

    @Test
    fun `use trip input port to refresh trips`() = runTest(StandardTestDispatcher()) {
        viewModel.intents.send(TripsIntent.RefreshTrips)

        coVerify { loadTripListInputPort.startUpdatingTripList() }
    }
}
