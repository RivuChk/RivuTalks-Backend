package dev.rivu.rivutalks.feature.aboutme.di

import dev.rivu.rivutalks.feature.aboutme.AboutmeController
import org.koin.dsl.module

val aboutmeModule = module {
    single { AboutmeController() }
}