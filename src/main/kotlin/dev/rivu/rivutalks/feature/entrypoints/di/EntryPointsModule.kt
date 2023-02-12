package dev.rivu.rivutalks.feature.entrypoints.di

import dev.rivu.rivutalks.feature.entrypoints.EntrypointsController
import org.koin.dsl.module

val entryPointsModule = module {
    single { EntrypointsController() }
}