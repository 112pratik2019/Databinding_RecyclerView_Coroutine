package com.example.sampleapiarch.network

import com.example.sampleapiarch.response.userRespone.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("api/users?page=2")
    suspend fun getAllUser(): Response<UserResponse>

}