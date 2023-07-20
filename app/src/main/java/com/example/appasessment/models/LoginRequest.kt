package com.example.appasessment.models

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName(" first_name") val userName: String,
    val password: String,
    val ConfirmPassword: String
)
