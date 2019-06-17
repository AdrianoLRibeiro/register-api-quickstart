package br.com.breiv.misc.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import javax.sql.DataSource

@SpringJUnitConfig(classes = [(PersistenceTestSetup::class)])
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
abstract class PersistenceTestCase {

    @Autowired
    private lateinit var dataSource: DataSource

    @Autowired
    private lateinit var appContext: ApplicationContext

    fun setUpPersistence(vararg scripts: String) {
        scripts.forEach {
            val script = appContext.getResource("classpath:/$it")
            ResourceDatabasePopulator(script).execute(dataSource)
        }
    }
}
