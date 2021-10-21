package com.example.sampleapiarch.data

import com.example.sampleapiarch.response.userRespone.UserResponse

sealed class Result{

    data class Success(val userResponse: UserResponse?):Result()
    data class Failed(val errorMsg: String):Result()
    object Loading : Result()
}
