package com.example.nycschool.ui.detail

import androidx.lifecycle.ViewModel
import com.example.nycschool.data.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val repository: SchoolRepository
) : ViewModel() {

}