package com.example.c7_koin.data

import com.example.c7_koin.data.service.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getPosts() = apiHelper.getAllPosts()
}