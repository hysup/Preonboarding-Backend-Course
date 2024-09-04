package com.teamsparta.assignment.domain.auth.dto

data class LoginRequest(
    val email: String,
    val password: String
)
