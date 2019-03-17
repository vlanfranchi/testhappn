package com.jehutyno.testhappn.ui.articles

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val title = view.title
    val date = view.date
    val description = view.description
    val thumbnail = view.thumbnail
    val author = view.author
    val bookmark = view.bookmark

}