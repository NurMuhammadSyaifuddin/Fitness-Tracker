package com.project.fitness.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor(){

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: Api = retrofit.create(Api::class.java)

    companion object{
        private const val BASE_URL = "https://newsapi.org/v2/"

        @Volatile
        private var instance: ApiClient? = null

        fun getInstance(): ApiClient =
            instance ?: synchronized(this){
                instance ?: ApiClient().apply { instance = this }
            }
    }

}