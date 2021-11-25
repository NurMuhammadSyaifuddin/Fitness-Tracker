package com.project.fitness.utils

import androidx.recyclerview.widget.DiffUtil
import com.project.fitness.models.News

class DivNewsCallback(
    private val oldNewsList: List<News>,
    private val nowNewsList: List<News>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldNewsList.size

    override fun getNewListSize(): Int = nowNewsList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldNewsList[oldItemPosition].title == nowNewsList[newItemPosition].title

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldNewsList[oldItemPosition].title == nowNewsList[newItemPosition].title
}