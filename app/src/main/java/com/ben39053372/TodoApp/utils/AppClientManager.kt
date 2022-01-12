package com.ben39053372.TodoApp.utils

import com.ben39053372.TodoApp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {
    private var retrofit: Retrofit
    private val okHttpClient = OkHttpClient()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }

}