package com.jehutyno.testhappn.ui.articles

data class ArticleItem(
    val id: String,
    val title: String,
    val date: String,
    val description: String,
    val author: String,
    val content: String?,
    val thumbnail: String?,
    var isFavorite: Boolean
)