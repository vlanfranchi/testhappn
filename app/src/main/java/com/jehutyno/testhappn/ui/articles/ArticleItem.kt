package com.jehutyno.testhappn.ui.articles

data class ArticleItem(
    val title: String,
    val date: String,
    val description: String,
    val author: String,
    val content: String?,
    val thumbnail: String?,
    val favorite_id: Long?
)