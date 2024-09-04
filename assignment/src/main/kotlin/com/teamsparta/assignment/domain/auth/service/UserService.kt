package com.teamsparta.assignment.domain.auth.service

import com.teamsparta.assignment.domain.auth.dto.LoginRequest
import com.teamsparta.assignment.domain.auth.dto.LoginResponse
import com.teamsparta.assignment.domain.auth.dto.SignUpRequest
import com.teamsparta.assignment.domain.auth.dto.UserResponse
import com.teamsparta.assignment.domain.auth.entity.User
import com.teamsparta.assignment.domain.auth.repository.UserRepository
import com.teamsparta.assignment.infra.security.jwt.JwtPlugin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) {

    fun signUp(request: SignUpRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("User email already exists")
        }
        val user = User(
            email = request.email,
            password = passwordEncoder.encode(request.password),
            nickname = request.nickname
        )

        val savedUser = userRepository.save(user)

        return savedUser.toResponse()
    }


    fun login(request: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(request.email)
        if (user == null ||!passwordEncoder.matches(request.password, user.password)) {
            throw IllegalArgumentException("User password invalid")
        }
        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = request.email

            )
        )

    }
    }