package dev.rivu.rivutalks

import dev.rivu.rivutalks.feature.aboutme.di.aboutmeModule
import dev.rivu.rivutalks.feature.blogs.data.blogsDataModule
import dev.rivu.rivutalks.feature.blogs.di.blogsModule
import dev.rivu.rivutalks.feature.entrypoints.di.entryPointsModule
import dev.rivu.rivutalks.feature.syncrss.di.syncRssModule
import dev.rivu.rivutalks.feature.videos.data.videosDataModule
import dev.rivu.rivutalks.feature.videos.di.videoModule

val koinModules = arrayOf(
    appModule,
    blogsModule,
    blogsDataModule,
    syncRssModule,
    videosDataModule,
    videoModule,
    entryPointsModule,
    aboutmeModule,
)