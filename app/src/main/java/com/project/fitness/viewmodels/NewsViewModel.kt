package com.project.fitness.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.fitness.api.ApiClient
import com.project.fitness.models.News
import com.project.fitness.models.NewsResponse
import com.project.fitness.utils.API_KEY
import com.project.fitness.utils.category
import com.project.fitness.utils.country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){

    private val listNews = MutableLiveData<List<News>>()
    private var toast: ((String) -> Unit)? = null

    fun setNews(){
        ApiClient.getInstance().api.getAllNews(country, category, API_KEY)
            .enqueue(object : Callback<NewsResponse>{
                override fun onResponse(
                    call: Call<NewsResponse>?,
                    response: Response<NewsResponse>?
                ) {
                    if (response?.isSuccessful as Boolean){
                        listNews.postValue(response.body()?.articles)
                    }
                }

                override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                    toast?.let { it(t?.message.toString()) }
                }

            })
    }

    fun getNews(): LiveData<List<News>> = listNews

    fun showToastFailure(toast: ((String) -> Unit)?){
        this.toast = toast
    }

    companion object{
        private val TAG = NewsViewModel::class.java.simpleName
    }

}