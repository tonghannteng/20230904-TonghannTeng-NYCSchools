package com.example.nycschool.service

import com.example.nycschool.data.model.School
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * @author: Tonghann Teng
 * @since: 9/4/2023
 */
interface ISchoolService {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchools(): List<School>
}
