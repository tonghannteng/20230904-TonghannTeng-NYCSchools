package com.example.nycschool.viewmodel

import app.cash.turbine.test
import com.example.nycschool.DispatcherProvider
import com.example.nycschool.MainCoroutineRule
import com.example.nycschool.TestData
import com.example.nycschool.data.model.School
import com.example.nycschool.data.repository.SchoolRepository
import com.example.nycschool.ui.UiState
import com.example.nycschool.ui.school.SchoolViewModel
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 */
@ExperimentalCoroutinesApi
class SchoolViewModelTest {

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val repository: SchoolRepository = mock()

    private lateinit var dispatcherProvider: DispatcherProvider

    @Before
    fun setUp() {
        dispatcherProvider = coroutineRule.testDispatcherProvider
    }

    @Test
    fun givenServerResponse200_whenGetSchoolsIsCalled_shouldReturnSuccess() {
        runTest {
            doReturn(flowOf(TestData.getSchoolMockData())).`when`(repository).getSchools()
            val viewModel = SchoolViewModel(
                repository = repository,
                dispatcherProvider = dispatcherProvider
            )
            viewModel.schoolList.test {
                assertEquals(awaitItem()::class, UiState.Loading::class)
                assertEquals(awaitItem()::class, UiState.Success::class)
                cancelAndConsumeRemainingEvents()
            }
            verify(repository).getSchools()
        }
    }

    @Test
    fun givenServerResponseError_whenGetSchoolsIsCalled_shouldReturnError() {
        runTest {
            val errorMessage = "Error Message"
            doReturn(flow<List<School>> {
                throw IllegalStateException(errorMessage)
            }).`when`(repository).getSchools()

            val viewModel = SchoolViewModel(
                repository = repository,
                dispatcherProvider = dispatcherProvider
            )

            viewModel.schoolList.test {
                assertEquals(awaitItem()::class, UiState.Loading::class)
                assertEquals(awaitItem()::class, UiState.Error::class)
                cancelAndConsumeRemainingEvents()
            }
            verify(repository).getSchools()
        }
    }
}
