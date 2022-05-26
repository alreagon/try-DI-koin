package com.example.c7_koin.di

import com.example.c7_koin.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel{
        MainActivityViewModel(get())
    }

}