package com.example.c7_koin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.c7_koin.data.Repository
import com.example.c7_koin.data.Resource
import com.example.c7_koin.data.model.GetAllPostsResponseItem
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    //gk perlu lagi viewmodelfactory karena di ViewModelModuleKoin nya udh ke provide sama koinnya

    private val _posts = MutableLiveData<Resource<List<GetAllPostsResponseItem>>>()
    val posts: LiveData<Resource<List<GetAllPostsResponseItem>>>
        get() = _posts

    fun getAllPosts(){
        viewModelScope.launch {
            _posts.postValue(Resource.loading())
            try {
                _posts.postValue(Resource.success(repository.getPosts()))
            }catch (exception: Exception){
                _posts.postValue(Resource.error(exception.message ?: "Error Occurred"))
            }
        }
    }
}