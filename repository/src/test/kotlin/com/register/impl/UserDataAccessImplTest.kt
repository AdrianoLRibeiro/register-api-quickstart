package com.register.impl

import br.com.breiv.misc.config.PersistenceTestCase
import com.register.entities.User
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserDataAccessImplTest : PersistenceTestCase() {

    @Autowired
    lateinit var userDataAccessImpl: UserDataAccessImpl

    @Test
    fun `should save bank slip payment`() {
        val user = User(name = "Adriano", email = "adrianolucianoribeiro@gmail.com")

        val expected = user.copy()

        assertEquals(expected, userDataAccessImpl.save(user))
    }

    @Test
    fun `should find bank slip payment`() {
        setUpPersistence("sql/users/users.sql")

        val expected =  User(name = "Adriano Ribeiro", email = "adrianolucianoribeiro@gmail.com")

        assertEquals(expected, userDataAccessImpl.findById(1L))
    }
}