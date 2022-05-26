package com.example.c7_koin.ui.view

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.c7_koin.R
import com.example.c7_koin.data.Status
import com.example.c7_koin.databinding.ActivityMainBinding
import com.example.c7_koin.ui.adapter.MainAdapter
import com.example.c7_koin.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModelKoin : MainActivityViewModel by viewModel() //ngambil vm yg qualifier
    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        adapter = MainAdapter()
        binding.rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvData.adapter = adapter

        binding.btnGetAllPosts.setOnClickListener {
            viewModelKoin.getAllPosts()
        }

        setupObservers()
    }

    fun setupObservers(){
        viewModelKoin.posts.observe(this){ resource ->
            when(resource.status){
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }

                Status.SUCCESS -> {
                    adapter.submitData(resource.data)
                    Toast.makeText(this, "Response Sukses : ${resource.data?.get(0)?.title}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error get Data : ${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}