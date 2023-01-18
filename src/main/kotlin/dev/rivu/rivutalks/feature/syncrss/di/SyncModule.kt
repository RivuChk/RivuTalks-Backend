package dev.rivu.rivutalks.feature.syncrss.di

import dev.rivu.rivutalks.feature.syncrss.SyncRssController
import org.koin.dsl.module
import java.text.SimpleDateFormat

val syncRssModule = module {

    single { SyncRssController(get(), get()) }

}