package com.example.nycschool.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.DispatcherProvider
import com.example.nycschool.data.model.SchoolDetail
import com.example.nycschool.data.repository.SchoolRepository
import com.example.nycschool.navigation.Argument
import com.example.nycschool.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val repository: SchoolRepository,
    private val dispatcherProvider: DispatcherProvider,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val TAG = "SchoolDetailViewModel"
    }

    private val dbnId: String? = savedStateHandle[Argument.DBN_ID]
    private var _schoolDetails = MutableStateFlow<UiState<List<SchoolDetail>>>(UiState.Loading())
    val schoolDetail = _schoolDetails.asStateFlow()

    init {
        if (dbnId.isNullOrEmpty()) {
            _schoolDetails.value = UiState.Error("dbnId not found")
        } else {
            getSchoolDetailList(dbn = dbnId)
        }
    }

    /**
     * Get school details list.
     */
    private fun getSchoolDetailList(dbn: String) {
        viewModelScope.launch(dispatcherProvider.main()) {
            repository.getSchoolDetail(dbn = dbn)
                .flowOn(dispatcherProvider.io())
                .catch {
                    _schoolDetails.value = UiState.Error(it.toString())
                }
                .collect {
                    if (it.isEmpty()) {
                        _schoolDetails.value = UiState.Error(error = "School Details is Empty")
                    } else {
                        _schoolDetails.value = UiState.Success(data = it)
                    }
                }
        }
    }
}
