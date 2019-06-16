package com.register.entity

import com.register.entities.User
import javax.persistence.*

@Entity(name ="users")
data class UserDAO (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String,

    var email: String
) {
    fun toEntity(): User = User(name = name, email = email)
}

fun User.toDao(): UserDAO = UserDAO(
    name = this.name,
    email = this.email
)