package com.example.nycschool.service

import com.example.nycschool.model.School
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author: Tonghann Teng
 * @since: 9/4/2023
 */
interface ISchoolService {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchools(): Response<List<School>>
}
