package com.teamsparta.assignment.domain.auth.controller

import com.teamsparta.assignment.domain.auth.dto.LoginRequest
import com.teamsparta.assignment.domain.auth.dto.LoginResponse
import com.teamsparta.assignment.domain.auth.dto.SignUpRequest
import com.teamsparta.assignment.domain.auth.dto.UserResponse
import com.teamsparta.assignment.domain.auth.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/user_signup")
    fun signUp(
        @RequestBody request: SignUpRequest
    ):
        ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.signUp(request))
    }

    @PostMapping("/user_login")
    fun login(
        @RequestBody request: LoginRequest
    ):
        ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.login(request))
    }

}