package com.teamsparta.assignment.domain.auth.repository

import com.teamsparta.assignment.domain.auth.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun existsByEmail(email: String): Boolean

    fun findByEmail(email: String): User?

}
