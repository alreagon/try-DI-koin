package com.example.c7_koin.data.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun getAllPosts() = apiService.getAllCars()
}