package com.project.fitness.ui.main.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.fitness.databinding.ItemNewsBinding
import com.project.fitness.models.News
import com.project.fitness.utils.DivNewsCallback

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var listener: ((News) -> Unit)? = null

    private var listNewsData = mutableListOf<News>()

    fun setListNewData(data: List<News>?){
        if (data == null) return
        val diffCallback = DivNewsCallback(this.listNewsData, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listNewsData.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: News){
            binding.apply {
                tvNewsTitle.text = data.title
                tvNewsAuthor.text = data.author
                tvNewsDesc.text = data.description

                itemView.setOnClickListener { listener?.let { it(data) } }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false).also {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNewsData[position])
    }

    override fun getItemCount(): Int = listNewsData.size

    fun onClick(listener: ((News) -> Unit)?){
        this.listener = listener
    }
}