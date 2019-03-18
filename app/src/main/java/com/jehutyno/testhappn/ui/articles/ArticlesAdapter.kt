package com.jehutyno.testhappn.ui.articles

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jehutyno.testhappn.R
import com.squareup.picasso.Picasso

class ArticlesAdapter(private val context: Context, var listener: OnArticleClickListener?) : RecyclerView.Adapter<ArticleViewHolder>() {

    private var items: List<ArticleItem> = listOf()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_article,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        items[position].apply {
            holder.title.text = title
            holder.description.text = description
            holder.author.text = author
            holder.date.text = date
            Picasso.get().load(thumbnail).placeholder(R.drawable.placeholder).into(holder.thumbnail)
            holder.bookmark.isChecked = favorite_id != null
            holder.itemView.setOnClickListener { listener?.onArticleClickListener(id) }
        }
    }

    fun update(items: List<ArticleItem>?) {
        items?.let {
            this.items = it
            notifyDataSetChanged()
        }
    }

    interface OnArticleClickListener {
        fun onArticleClickListener(articleId: String)
    }

}