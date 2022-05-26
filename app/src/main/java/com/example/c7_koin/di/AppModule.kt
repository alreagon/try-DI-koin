package com.example.c7_koin.di

import com.example.c7_koin.BuildConfig
import com.example.c7_koin.data.service.ApiHelper
import com.example.c7_koin.data.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl((BuildConfig.BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }


    single {
        return@single ApiHelper(get())
    }
//    singleOf(::apiHelperKoin)


}
