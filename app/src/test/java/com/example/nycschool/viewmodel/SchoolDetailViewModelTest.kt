package com.example.nycschool.viewmodel

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.nycschool.DispatcherProvider
import com.example.nycschool.MainCoroutineRule
import com.example.nycschool.TestData
import com.example.nycschool.data.model.SchoolDetail
import com.example.nycschool.data.repository.SchoolRepository
import com.example.nycschool.navigation.Argument
import com.example.nycschool.ui.UiState
import com.example.nycschool.ui.detail.SchoolDetailViewModel
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 */
@ExperimentalCoroutinesApi
class SchoolDetailViewModelTest {

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val repository: SchoolRepository = mock()
    private val savedStateHandle: SavedStateHandle = mock()

    private lateinit var dispatcherProvider: DispatcherProvider

    @Before
    fun setUp() {
        dispatcherProvider = coroutineRule.testDispatcherProvider
    }

    @Test
    fun givenServerResponse200_whenGetSchoolDetailListIsCalled_shouldReturnSuccess() {
        val dbnId = "dbnId"
        runTest {
            doReturn(dbnId).`when`(savedStateHandle).get<String>(Argument.DBN_ID)
            doReturn(flowOf(TestData.getSchoolDetailMockData())).`when`(repository)
                .getSchoolDetail(dbn = dbnId)
            val viewModel = SchoolDetailViewModel(
                repository = repository,
                dispatcherProvider = dispatcherProvider,
                savedStateHandle = savedStateHandle
            )
            viewModel.schoolDetail.test {
                assertEquals(awaitItem()::class, UiState.Loading::class)
                assertEquals(awaitItem()::class, UiState.Success::class)
                cancelAndConsumeRemainingEvents()
            }
            verify(repository).getSchoolDetail(dbn = dbnId)
        }
    }

    @Test
    fun givenServerResponseError_whenGetSchoolDetailListIsCalled_shouldReturnError() {
        val dbnId = "dbnId"
        runTest {
            doReturn(dbnId).`when`(savedStateHandle).get<String>(Argument.DBN_ID)
            val errorMessage = "Error Message"
            doReturn(flow<List<SchoolDetail>> {
                throw IllegalStateException(errorMessage)
            }).`when`(repository).getSchoolDetail(dbn = dbnId)

            val viewModel = SchoolDetailViewModel(
                repository = repository,
                dispatcherProvider = dispatcherProvider,
                savedStateHandle = savedStateHandle
            )
            viewModel.schoolDetail.test {
                assertEquals(awaitItem()::class, UiState.Loading::class)
                assertEquals(awaitItem()::class, UiState.Error::class)
                cancelAndConsumeRemainingEvents()
            }
            verify(repository).getSchoolDetail(dbn = dbnId)
        }
    }

    @Test
    fun givenDbnIdIsNull_whenViewModelInit_shouldReturnErrorState() {
        val dbnId = null
        runTest {
            doReturn(dbnId).`when`(savedStateHandle).get<String>(Argument.DBN_ID)
            val viewModel = SchoolDetailViewModel(
                repository = repository,
                dispatcherProvider = dispatcherProvider,
                savedStateHandle = savedStateHandle
            )
            viewModel.schoolDetail.test {
                assertEquals(awaitItem()::class, UiState.Error::class)
                cancelAndConsumeRemainingEvents()
            }
            verifyNoMoreInteractions(repository)
        }
    }

    @Test
    fun givenServerResponse200AndResponseIsEmpty_whenGetSchoolDetailListIsCalled_shouldReturnError() {
        val dbnId = "dbnId"
        runTest {
            doReturn(dbnId).`when`(savedStateHandle).get<String>(Argument.DBN_ID)
            doReturn(flowOf(emptyList<SchoolDetail>())).`when`(repository)
                .getSchoolDetail(dbn = dbnId)
            val viewModel = SchoolDetailViewModel(
                repository = repository,
                dispatcherProvider = dispatcherProvider,
                savedStateHandle = savedStateHandle
            )
            viewModel.schoolDetail.test {
                assertEquals(awaitItem()::class, UiState.Loading::class)
                assertEquals(awaitItem()::class, UiState.Error::class)
                cancelAndConsumeRemainingEvents()
            }
            verify(repository).getSchoolDetail(dbn = dbnId)
        }
    }
}
