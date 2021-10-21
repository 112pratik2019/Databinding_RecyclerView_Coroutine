package com.example.sampleapiarch.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sampleapiarch.R
import com.example.sampleapiarch.databinding.ActivityMainBinding
import com.example.sampleapiarch.ui.adapter.UserAdapter
import com.example.sampleapiarch.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {


    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        binding.apply {
            binding.lifecycleOwner = this@MainActivity
            binding.userViewModel = mainViewModel
        }

        mainViewModel.getDataListLiveData().observe(this, { result ->
            val adapter=UserAdapter(result)
            binding.recyclerViewUsers.adapter=adapter
        })
    }
}