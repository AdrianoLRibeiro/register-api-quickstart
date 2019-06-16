package com.register.user.dto

import com.register.entities.User
import org.hibernate.validator.constraints.Email


data class UserDTO (

    val name: String = "",

    @field:Email(message = "Invalid email format")
    val email: String = ""

) {
    fun toEntity() = User(name = name, email = email)
}

fun User.toDto(): UserDTO = UserDTO(name = this.name, email = this.email)

