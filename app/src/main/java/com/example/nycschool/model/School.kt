package com.example.nycschool.model

/**
 * @author: tonghann.teng
 * @since: 9/4/2023
 *
 * Data class represents [School] object.
 */
data class School(
    val dbn: String,
    val school_name: String,
    val boro: String,
    val overview_paragraph: String,
    val school_10th_seats: String,
    val language_classes: String,
    val location: String,
    val phone_number: String,
    val school_email: String
)
