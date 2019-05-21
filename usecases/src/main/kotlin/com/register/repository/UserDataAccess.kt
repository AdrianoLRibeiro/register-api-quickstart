package com.register.repository

import com.register.entities.User

interface UserDataAccess {
    fun findById(id: Long): User?
    fun save(user: User): User
}