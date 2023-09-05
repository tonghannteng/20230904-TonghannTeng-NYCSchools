package com.example.nycschool.data.repository

import com.example.nycschool.data.model.School
import com.example.nycschool.data.model.SchoolDetail
import com.example.nycschool.service.ISchoolService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
class SchoolRepository @Inject constructor(
    private val schoolService: ISchoolService
) : ISchoolRepository {

    override suspend fun getSchools(): Flow<List<School>> {
        return flow {
            emit(schoolService.getSchools())
        }
    }

    override suspend fun getSchoolDetail(dbn: String): Flow<List<SchoolDetail>> {
        return flow {
            emit(schoolService.getSchoolDetail(dbn = dbn))
        }
    }
}
