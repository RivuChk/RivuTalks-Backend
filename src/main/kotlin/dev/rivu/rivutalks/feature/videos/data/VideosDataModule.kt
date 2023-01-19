package dev.rivu.rivutalks.feature.videos.data

import org.koin.dsl.module

val videosDataModule = module {
    single<VideosnChannelsDAO> { VideosnChannelsDAOImpl() }
}