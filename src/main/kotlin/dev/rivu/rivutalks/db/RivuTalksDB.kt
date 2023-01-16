package dev.rivu.rivutalks.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dev.rivu.rivutalks.db.table.Blogs
import dev.rivu.rivutalks.db.table.Sites
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

fun initDatabase(DBConfig: DBConfig) {
    val tables = arrayOf(Blogs, Sites)

    Database.connect(createDataSource(DBConfig))

    transaction {
        SchemaUtils.createMissingTablesAndColumns(*tables)
    }
}

private fun createDataSource(DBConfig: DBConfig): DataSource {
    val config = HikariConfig()
    with(DBConfig) {
        config.driverClassName = driver
        config.password = password
        config.jdbcUrl = "jdbc:postgresql://$host:$port/$name"
        config.maximumPoolSize = maxPoolSize
        config.username = user
    }
    config.validate()
    return HikariDataSource(config)
}