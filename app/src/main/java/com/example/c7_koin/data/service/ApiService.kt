package com.example.c7_koin.data.service

import com.example.c7_koin.data.model.GetAllPostsResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getAllPosts(): List<GetAllPostsResponseItem>
}