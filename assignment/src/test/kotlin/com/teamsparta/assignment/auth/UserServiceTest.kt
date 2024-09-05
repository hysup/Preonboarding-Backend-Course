package com.teamsparta.assignment.auth

import com.teamsparta.assignment.domain.auth.dto.SignUpRequest
import com.teamsparta.assignment.domain.auth.dto.UserResponse
import com.teamsparta.assignment.domain.auth.entity.User
import com.teamsparta.assignment.domain.auth.repository.UserRepository
import com.teamsparta.assignment.domain.auth.service.UserService
import com.teamsparta.assignment.infra.security.jwt.JwtPlugin
import io.kotest.assertions.any
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.springframework.security.crypto.password.PasswordEncoder


class UserServiceTest: BehaviorSpec({

    val userRepository: UserRepository = mockk()
    val passwordEncoder: PasswordEncoder = mockk()
    val jwtPlugin: JwtPlugin = mockk()
    val userService = UserService(userRepository, passwordEncoder, jwtPlugin)

    afterEach {
        clearAllMocks()
    }

    Given("유저가 회원가입을 할 때") {

        val request = SignUpRequest(
            email = "test@test09.com",
            nickname = "test10",
            password = "test1234",
        )

        When("이메일이 이미 존재하는 경우") {
            every { userRepository.findByEmail(request.email) } returns User(
                email = request.email,
                nickname = request.nickname,
                password = "encodedPassword"
            )

            Then("IllegalArgumentException 발생") {
                shouldThrow<IllegalArgumentException> {
                    userService.signUp(request)
                }.message shouldBe "User email already exists"
            }
        }

    }
})






