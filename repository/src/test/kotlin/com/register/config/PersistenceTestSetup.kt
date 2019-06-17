package br.com.breiv.misc.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@ComponentScan("com.register.*")
@EnableJpaRepositories(basePackages = ["com.register.*"])
class PersistenceTestSetup {

    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager().apply {
            this.entityManagerFactory = entityManagerFactory
        }
    }

    @Bean
    fun entityManagerFactory(dataSource: DataSource): LocalContainerEntityManagerFactoryBean {
        val jpaProperties = Properties().apply {
            this["hibernate.dialect"] = "org.hibernate.dialect.H2Dialect"
            this["hibernate.ejb.naming_strategy"] = "org.hibernate.cfg.ImprovedNamingStrategy"
            this["hibernate.show_sql"] = false
            this["hibernate.format_sql"] = true
            this["hibernate.hbm2ddl.auto"] = "create"
        }

        return LocalContainerEntityManagerFactoryBean().apply {
            this.dataSource = dataSource
            jpaVendorAdapter = HibernateJpaVendorAdapter()
            setPackagesToScan("com.register.*")
            setJpaProperties(jpaProperties)
        }
    }

    @Bean
    fun dataSource(): DataSource = HikariDataSource(
        HikariConfig().apply {
            jdbcUrl = "jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE;MVCC=FALSE"
            username = "sa"
            password = ""
            maximumPoolSize = 60
            minimumIdle = 20
        }
    )
}