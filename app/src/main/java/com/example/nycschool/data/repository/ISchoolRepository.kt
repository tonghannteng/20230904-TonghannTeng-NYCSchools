package com.example.nycschool.data.repository

import com.example.nycschool.data.model.School
import com.example.nycschool.data.model.SchoolDetail
import kotlinx.coroutines.flow.Flow

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
interface ISchoolRepository {

    /**
     * Get all schools list.
     */
    suspend fun getSchools(): Flow<List<School>>

    /**
     * Get all school details list.
     */
    suspend fun getSchoolDetail(dbn: String): Flow<List<SchoolDetail>>
}
