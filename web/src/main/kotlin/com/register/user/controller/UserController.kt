package com.register.user.controller

import com.register.service.UserService
import com.register.user.dto.UserDTO
import com.register.user.dto.toDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun save(@Valid @RequestBody user: UserDTO): ResponseEntity<UserDTO> {

        userService.save(user = user.toEntity())

        return ResponseEntity.ok(user)
    }

    @GetMapping
    fun findById(@PathVariable("id") id: Long): ResponseEntity<UserDTO> {

        val user = userService.findById(id)

        return if (user != null) ResponseEntity.ok(user.toDto()) else ResponseEntity.notFound().build()
    }
}
