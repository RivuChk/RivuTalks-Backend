package dev.rivu.rivutalks.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dev.rivu.rivutalks.db.table.Blogs
import dev.rivu.rivutalks.db.table.Channels
import dev.rivu.rivutalks.db.table.Sites
import dev.rivu.rivutalks.db.table.Videos
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

fun initDatabase(DBConfig: DBConfig) {
    val tables = arrayOf(Blogs, Sites, Videos, Channels)

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