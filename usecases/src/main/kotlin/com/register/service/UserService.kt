package com.register.service

import com.register.entities.User
import com.register.repository.UserDataAccess
import org.springframework.stereotype.Service

@Service
class UserService (private val dataAccess: UserDataAccess) {

    fun save(user: User) = dataAccess.save(user)

    fun findById(id: Long) = dataAccess.findById(id)
}