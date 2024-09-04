package com.teamsparta.assignment.domain.auth.entity

import com.teamsparta.assignment.domain.auth.dto.UserResponse
import jakarta.persistence.*

@Entity
@Table(name = "app_user")
class User(

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "nickname")
    val nickname: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toResponse(): UserResponse {
        return UserResponse(
            id = this.id ?: -1,
            email = this.email,
            nickname = this.nickname,
        )
    }
}