package com.example.nycschool.data.repository

import com.example.nycschool.data.model.School
import com.example.nycschool.service.ISchoolService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SchoolRepository @Inject constructor(
    private val schoolService: ISchoolService
) : ISchoolRepository {

    override suspend fun getSchools(): Flow<List<School>> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(schoolService.getSchools())
            }
        }
    }
}
