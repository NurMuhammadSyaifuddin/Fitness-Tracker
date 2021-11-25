package com.project.fitness.ui.main.news

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.project.fitness.databinding.FragmentNewsBinding
import com.project.fitness.viewmodels.NewsViewModel

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding as FragmentNewsBinding
    private lateinit var adapter: NewsAdapter

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init
        adapter = NewsAdapter()
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[NewsViewModel::class.java]

        getNewsData()

        setUpRecyclerView()

        onAction()
    }

    private fun setUpRecyclerView() {
        binding.apply {
            rvNews.setHasFixedSize(true)
            rvNews.adapter = adapter
        }
    }

    private fun onAction() {
        binding.apply {
            swipeRefresh.setOnRefreshListener { getNewsData() }

            adapter.onClick {
                Intent(activity, DetailNewsActivity::class.java).also { intent ->
                    intent.putExtra(DetailNewsActivity.EXTRA_URL, it.url)
                    startActivity(intent)
                }
            }
        }
    }

    private fun getNewsData() {
        binding.apply {
            swipeRefresh.isRefreshing = true

            viewModel.showToastFailure {
                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
            }
            
            viewModel.setNews()
            viewModel.getNews().observe(viewLifecycleOwner){
                adapter.setListNewData(it)
                swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}