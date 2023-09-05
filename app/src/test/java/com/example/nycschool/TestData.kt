package com.example.nycschool

import com.example.nycschool.data.model.School
import com.example.nycschool.data.model.SchoolDetail

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 */
object TestData {

    private val schoolDataList = mutableListOf<School>()
    private val schoolDetailDataList = mutableListOf<SchoolDetail>()

    fun getSchoolMockData(): List<School> {
        schoolDataList.add(
            School(
                dbn = "dbn",
                school_name = "school name",
                boro = "M",
                overview_paragraph = "overview paragraph",
                school_10th_seats = "school 10th seats",
                language_classes = "language classes",
                location = "location",
                phone_number = "phone number",
                school_email = "school email"
            )
        )
        return schoolDataList
    }

    fun getSchoolDetailMockData(): List<SchoolDetail> {
        schoolDetailDataList.add(
            SchoolDetail(
                dbn = "dbn",
                school_name = "school name",
                num_of_sat_test_takers = "num of sat test takers",
                sat_critical_reading_avg_score = "sat critical reading avg score",
                sat_math_avg_score = "sat math avg score",
                sat_writing_avg_score = "sat writing avg score"
            )
        )
        return schoolDetailDataList
    }
}
