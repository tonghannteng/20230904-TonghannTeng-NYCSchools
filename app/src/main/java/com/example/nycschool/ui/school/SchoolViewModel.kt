package com.example.nycschool.ui.school

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschool.data.model.School
import com.example.nycschool.data.repository.SchoolRepository
import com.example.nycschool.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(
    private val repository: SchoolRepository
) : ViewModel() {

    companion object {
        private const val TAG = "SchoolViewModel"
    }

    private var _schoolList = MutableStateFlow<UiState<List<School>>>(UiState.Loading())
    val schoolList = _schoolList.asStateFlow()

    init {
        getSchoolList()
    }

    private fun getSchoolList() {
        viewModelScope.launch {
            repository.getSchools()
                .catch {
                    _schoolList.value = UiState.Error(it.toString())
                }
                .collect {
                    _schoolList.value = UiState.Success(it)
                }
        }
    }

}
