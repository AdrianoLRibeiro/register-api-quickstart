package com.register.impl

import br.com.breiv.misc.config.PersistenceTestCase
import org.springframework.beans.factory.annotation.Autowired
import org.junit.jupiter.api.Test

class UserDataAccessImplTest : PersistenceTestCase() {

    @Autowired
    lateinit var userDataAccessImpl: UserDataAccessImpl


    @Test
    fun `should save bank slip payment`() {

    }
}