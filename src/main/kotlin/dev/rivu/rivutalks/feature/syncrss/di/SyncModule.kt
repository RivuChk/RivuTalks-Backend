package dev.rivu.rivutalks.feature.syncrss.di

import dev.rivu.rivutalks.feature.syncrss.SyncRssController
import org.koin.dsl.module

val syncRssModule = module {
    single { SyncRssController(get()) }
    //single { ParserBase<RivuChannel>() }
}