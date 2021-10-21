package com.example.sampleapiarch.network

import com.example.sampleapiarch.util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder()
            .addNetworkInterceptor(loggingInterceptor)
            .connectTimeout(4, TimeUnit.MINUTES)
            .readTimeout(4, TimeUnit.MINUTES)
            .build()
    }

    fun getApiService(): API {
        return createRetrofit().create(API::class.java)
    }

}