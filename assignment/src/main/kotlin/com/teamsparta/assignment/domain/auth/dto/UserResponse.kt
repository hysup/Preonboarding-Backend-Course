package com.teamsparta.assignment.domain.auth.dto

import com.teamsparta.assignment.domain.auth.entity.User

data class UserResponse(
    val id: Long?,
    val email: String,
    val nickname: String,
)
