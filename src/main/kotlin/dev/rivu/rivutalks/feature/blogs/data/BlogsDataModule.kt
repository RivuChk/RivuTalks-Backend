package dev.rivu.rivutalks.feature.blogs.data

import org.koin.dsl.module

val blogsDataModule = module {
    single<BlogsDao> { BlogsDaoImpl() }
}