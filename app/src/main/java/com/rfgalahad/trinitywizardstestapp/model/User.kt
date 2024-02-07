package com.rfgalahad.trinitywizardstestapp.model

import java.io.Serializable

data class User(

    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dob: String,
) : Serializable
