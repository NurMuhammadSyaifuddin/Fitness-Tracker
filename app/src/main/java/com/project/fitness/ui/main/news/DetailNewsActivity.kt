package com.project.fitness.ui.main.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.fitness.databinding.ActivityDetailNewsBinding

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadWebView()
    }

    private fun loadWebView() {
        binding.apply {
            val url = intent.extras?.getString(EXTRA_URL) as String
            webViewDetailNews.loadUrl(url)
        }
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

    companion object{
        const val EXTRA_URL = "extra_url"
    }
}