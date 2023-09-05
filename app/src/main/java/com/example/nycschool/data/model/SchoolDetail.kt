package com.example.nycschool.data.model

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 * Data class represents [SchoolDetail] object.
 */
data class SchoolDetail(
    val dbn: String,
    val school_name: String,
    val num_of_sat_test_takers: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String
)