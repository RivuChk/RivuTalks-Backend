package dev.rivu.rivutalks

import io.ktor.server.application.*
import io.ktor.server.config.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.text.SimpleDateFormat
import kotlin.coroutines.CoroutineContext

val appModule = module {
    single<CoroutineContext> {
        Dispatchers.IO + Job()
    }
    single {
        SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzzz")
    }
    single(named("appConfig")) {
        get<ApplicationEnvironment>().config
    }
    single(named("sync_key")) {
        get<ApplicationConfig>(named("appConfig")).config("key").property("sync").getString()
    }
}