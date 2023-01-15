package dev.rivu.rivutalks.feature.blogs.di

import dev.rivu.rivutalks.feature.blogs.BlogsController
import dev.rivu.rivutalks.feature.blogs.BlogsRepository
import dev.rivu.rivutalks.feature.blogs.BlogsRepositoryImpl
import dev.rivu.rivutalks.feature.blogs.BlogsService
import org.koin.dsl.module

val blogsModule = module {
    single { BlogsController(get()) }
    single { BlogsService(get()) }
    single<BlogsRepository> { BlogsRepositoryImpl() }
}