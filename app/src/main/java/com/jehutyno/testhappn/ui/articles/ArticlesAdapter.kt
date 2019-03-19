package com.jehutyno.testhappn.ui.articles

import android.content.Context
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jehutyno.testhappn.R
import com.jehutyno.testhappn.extensions.favoriteEnabled
import com.squareup.picasso.Picasso

class ArticlesAdapter(private val context: Context, var listener: OnArticleClickListener?) :
    RecyclerView.Adapter<ArticleViewHolder>() {

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
            val isFavorite = favoriteId != null
            holder.bookmark.visibility = if (favoriteEnabled) VISIBLE else GONE
            holder.bookmark.isChecked = isFavorite
            holder.bookmark.setOnClickListener {
                holder.bookmark.isChecked = isFavorite
                listener?.onFavoriteClickListener(id, favoriteId)
            }
            holder.itemView.setOnClickListener { listener?.onArticleClickListener(id) }
        }
    }

    fun update(items: List<ArticleItem>?) {
        items?.let {
            this.items = it
            notifyDataSetChanged()
        }
    }

    fun updateFavorite(articleId: String, favoriteId: String?) {
        val position = items.indexOfFirst { it.id == articleId }
        items[position].favoriteId = favoriteId
        notifyItemChanged(position)
    }

    interface OnArticleClickListener {
        fun onArticleClickListener(articleId: String)
        fun onFavoriteClickListener(articleId: String, favoriteId: String?)
    }

}