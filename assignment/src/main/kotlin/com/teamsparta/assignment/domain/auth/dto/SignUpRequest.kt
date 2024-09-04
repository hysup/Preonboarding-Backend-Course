package com.teamsparta.assignment.domain.auth.dto

data class SignUpRequest(
    val email: String,
    val password: String,
    val nickname: String,
)
