package com.jehutyno.domain.model

data class Article(
    val _id: String,
    val title: String,
    val pubDate: String,
    val link: String,
    val description: String,
    val guid: String,
    val author: String,
    val content: String?,
    val categories: List<String>?,
    val thumbnail: String?,
    val favorite_id: String?
)