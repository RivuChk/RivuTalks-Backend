package dev.rivu.rivutalks.feature.videos.di

import dev.rivu.rivutalks.feature.videos.VideosController
import dev.rivu.rivutalks.feature.videos.VideosRepository
import dev.rivu.rivutalks.feature.videos.VideosRepositoryImpl
import dev.rivu.rivutalks.feature.videos.VideosnChannelService
import org.koin.dsl.module

val videoModule = module {
    single { VideosController(get()) }
    single { VideosnChannelService(get()) }
    single<VideosRepository> { VideosRepositoryImpl(get()) }
}