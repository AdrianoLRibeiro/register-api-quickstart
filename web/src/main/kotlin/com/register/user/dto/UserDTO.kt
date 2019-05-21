package com.register.user.dto

import com.register.entities.User


data class UserDTO (
    val name: String = "",
    val email: String = ""
) {
    fun toEntity() = User(name = name, email = email)
}

fun User.toDto(): UserDTO = UserDTO(name = this.name, email = this.email)

