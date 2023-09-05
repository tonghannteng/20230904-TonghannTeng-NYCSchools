package com.example.nycschool.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.data.model.SchoolDetail
import com.example.nycschool.data.repository.SchoolRepository
import com.example.nycschool.navigation.Argument
import com.example.nycschool.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val TAG = "SchoolDetailViewModel"
    }

    private val dbnId: String? = savedStateHandle[Argument.DBN_ID]
    private var _schoolDetails = MutableStateFlow<UiState<List<SchoolDetail>>>(UiState.Loading())
    val schoolDetail = _schoolDetails.asStateFlow()

    init {
        dbnId?.let {
            getSchoolDetailList(dbn = dbnId)
        }
    }

    /**
     * Get school details list.
     */
    private fun getSchoolDetailList(dbn: String) {
        viewModelScope.launch {
            repository.getSchoolDetail(dbn = dbn)
                .catch {
                    _schoolDetails.value = UiState.Error(it.toString())
                }
                .collect {
                    _schoolDetails.value = UiState.Success(data = it)
                }
        }
    }
}
