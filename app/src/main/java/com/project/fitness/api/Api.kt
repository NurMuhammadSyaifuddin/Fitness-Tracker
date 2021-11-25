package com.project.fitness.api

import com.project.fitness.models.NewsResponse
import com.project.fitness.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("top-headlines")
    fun getAllNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Call<NewsResponse>

}