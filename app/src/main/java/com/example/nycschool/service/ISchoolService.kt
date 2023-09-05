package com.example.nycschool.service

import com.example.nycschool.data.model.School
import com.example.nycschool.data.model.SchoolDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author: Tonghann Teng
 * @since: 9/4/2023
 */
interface ISchoolService {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchools(): List<School>

    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolDetail(@Query("dbn") dbn: String): List<SchoolDetail>
}
