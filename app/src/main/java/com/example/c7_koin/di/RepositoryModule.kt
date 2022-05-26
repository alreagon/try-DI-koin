package com.example.c7_koin.di

import com.example.c7_koin.data.Repository
import org.koin.dsl.module

val repositoryModule = module{

    single {
        Repository(get())
    }
}