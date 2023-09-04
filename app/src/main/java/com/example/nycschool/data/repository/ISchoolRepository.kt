package com.example.nycschool.data.repository

import com.example.nycschool.data.model.School
import kotlinx.coroutines.flow.Flow

interface ISchoolRepository {

    suspend fun getSchools(): Flow<List<School>>
}