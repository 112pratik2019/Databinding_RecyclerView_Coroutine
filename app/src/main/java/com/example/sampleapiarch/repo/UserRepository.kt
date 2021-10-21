package com.example.sampleapiarch.repo

import com.example.sampleapiarch.data.Result
import com.example.sampleapiarch.response.userRespone.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class UserRepository {


    companion object {
        fun getUsers(apiCall: suspend () -> Response<UserResponse>): Flow<Result> = flow {
            emit(Result.Loading)
            val response = apiCall.invoke()
            if (response.isSuccessful) {
                emit(Result.Success(response.body()))
            } else {
                emit(Result.Failed("Error"))
            }
        }.flowOn(Dispatchers.IO)
    }


}