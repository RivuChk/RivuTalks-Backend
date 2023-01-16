package dev.rivu.rivutalks.db

class DBConfig(
    val host: String,
    val port: String,
    val name: String,
    val user: String,
    val password: String,
    val driver: String,
    val maxPoolSize: Int
)