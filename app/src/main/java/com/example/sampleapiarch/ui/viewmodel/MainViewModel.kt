package com.example.sampleapiarch.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapiarch.data.Result
import com.example.sampleapiarch.network.ApiFactory
import com.example.sampleapiarch.repo.UserRepository
import com.example.sampleapiarch.response.userRespone.Data
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val loading = MutableLiveData<Int>()
    private val dataList = MutableLiveData<List<Data>>()

    init {
        getUsers()
    }

    fun getDataListLiveData(): LiveData<List<Data>> = dataList


    private fun getUsers() {
        viewModelScope.launch {
            UserRepository.getUsers { ApiFactory.getApiService().getAllUser() }.collect { result ->
                when (result) {
                    Result.Loading -> {
                        loading.value = View.VISIBLE
                    }
                    is Result.Success -> {
                        loading.value = View.GONE
                        dataList.value = result.userResponse?.data
                    }
                    is Result.Failed -> {
                        loading.value = View.VISIBLE
                    }
                }

            }
        }
    }
}


