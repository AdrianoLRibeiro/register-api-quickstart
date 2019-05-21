package com.register.entity

import com.register.entities.User
import javax.persistence.*

@Entity(name ="users")
class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq")
    var id: Long? = null

    lateinit var name: String

    lateinit var email: String

    fun toEntity(): User = User(name = name, email = email)
}

fun User.toDao(): UserDAO = UserDAO().apply {
    name = this@toDao.name
    email = this@toDao.email
}