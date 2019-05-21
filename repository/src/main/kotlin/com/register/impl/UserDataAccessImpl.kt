package com.register.impl

import com.register.entities.User
import com.register.entity.toDao
import com.register.repository.UserDataAccess
import com.register.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserDataAccessImpl(private val userRepository: UserRepository) : UserDataAccess {

    override fun findById(id: Long): User? = userRepository.findById(id).map { it.toEntity() }.orElse(null)

    override fun save(user: User): User = userRepository.save(user.toDao()).toEntity()

}